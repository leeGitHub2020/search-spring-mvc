package test;



import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import quadbase.ChartAPI.ColInfo;
import quadbase.ChartAPI.DbData;
import quadbase.ChartAPI.QbChart;
import quadbase.chart.Line;
import quadbase.util.IAxis;
import quadbase.util.ICanvas;
import quadbase.util.IDataPointSet;
import quadbase.util.IHorzVertLine;
import quadbase.util.ILabel;
import quadbase.util.ILegend;
import quadbase.util.IMouseEventSet;
import quadbase.util.IPlot;
import quadbase.util.NumericFormat;
import quadbase.util.Position;

@Controller
public class ChartFormController {

    @ModelAttribute
    public ChartForm setForm() {
        return new ChartForm();
    }

    @RequestMapping(value = "test/chart")
    public String index(ChartForm form, Model model) {

        return "test/chart";
    }

    @RequestMapping(value = "test/chart/showchart")
    public String index(HttpServletResponse resp) {

        OutputStream out = null;
        try {
            out = resp.getOutputStream();
            out.write(getChart(1));
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO 自動生成された catch ブロック
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    /**
     * PNGデータ取得
     *
     * @return
     */
    byte[] getChart(int model) {

        // Do not use EspressManager
        QbChart.setEspressManagerUsed(false);

        // DBからデータ取得
        // DBInfo databaseInfo =
        // new DBInfo("jdbc:postgresql://localhost:5432/sample", "org.postgresql.Driver",
        // "postgres", "abc123", "select year, record from m_chart order by year");

        // テストデータ
        String dataType[] = {"varchar", "decimal"};
        String fieldName[] = {"year", "record"};


        String[][] records = null;
        if (model == 1) {
            records = new String[][] {{"2002", "225.0"}, {"2003", "210.0"}, {"2004", "260.0"},
                    {"2005", "200.0"}, {"2006", "261.0"}, {"2007", "263.0"}, {"2008", "263.0"},
                    {"2009", "240.0"}, {"2010", "230.0"}, {"2011", "215.0"}, {"2012", "200.0"},
                    {"2013", "233.0"}, {"2014", "199.0"}, {"2015", "236.0"}, {"2016", "203.0"},
                    {"2017", "210.0"}, {"2018", "200.0"}, {"2019", "182.0"}, {"2020", null}};
        } else {
            records = new String[][] {{"2018", null}, {"2019", "052.0"}, {"2020", null}};
        }

        DbData databaseInfo = new DbData(dataType, fieldName, records);

        // Column Mapping
        ColInfo columnMapping = new ColInfo();
        columnMapping.category = 0;
        columnMapping.value = 1;

        // Apply the template
        QbChart chart = new QbChart((Applet) null, // container
                QbChart.VIEW2D, // chart dimension
                QbChart.LINE, // chart type
                databaseInfo, // data
                columnMapping, // column mapping
                null); // template

        int canvasWidth = 800;
        int canvasHeight = 380;

        // キャンバス設定
        ICanvas canvas = chart.gethCanvas();
        // グラフサイズ指定
        canvas.setSize(new Dimension(canvasWidth, canvasHeight));
        // キャンバスで切り落とされるグラフ要素調整
        canvas.setFitOnCanvas(true);
        // スクロールバーを無効にする
        canvas.setScrollBarOption(ScrollPane.SCROLLBARS_NEVER);
        // グラフ背景色設定
        canvas.setBackgroundColor(Color.WHITE);

        // グラフアンチエイリアス設定
        chart.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
                java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

        // ドラッグイベントを無効にする
        IMouseEventSet mouseEvent = chart.gethMouseEvents();
        mouseEvent.setDragEnabled(false);

        // プロットエリア設定
        IPlot chartPlot = chart.gethChartPlot();
        // プロットエリア境界を表示にする
        chartPlot.setBorderVisible(true);

        // プロットエリアの原点xの割合
        float px = (float) 0.07;
        // プロットエリアの原点ｙの割合
        float py = (float) 0.04;
        // タイトルの高さｙの割合
        float uy = (float) 0.1;
        // プロットエリア境界囲み枠設定
        chartPlot.setPosition(new Position(px, py + uy));
        chartPlot.setRelativeWidth(1 - px * 2);
        chartPlot.setRelativeHeight(1 - py * 2 - uy);

        // 凡例ボックス
        ILegend hLegend = chart.gethLegend();
        // 凡例ボックスを非表示にする
        hLegend.setVisible(false);

        // X軸設定
        IAxis xAxis = chart.gethXAxis();
        // X軸グリッドを表示にする
        xAxis.setGridVisible(true);
        // X軸ティッカーを非表示にする
        xAxis.setTickersVisible(false);
        if (model == 1) {
            trikerAndLabelStep(xAxis, 2);
        } else {
            trikerAndLabelStep(xAxis, 1);
        }
        xAxis.setArrowhead(false);

        // y軸設定
        IAxis yAxis = chart.gethYAxis();
        // y軸グリッドを非表示にする
        yAxis.setGridVisible(false);
        // y軸ティッカーを非表示にする
        yAxis.setTickersVisible(false);
        // 角度設定
        yAxis.gethTitle().setAngle(0);
        // オフセット設定
        int fSize = yAxis.gethLabel().getFont().getSize();
        int fPix = 0;
        if (model == 1) {
            fPix = (int) (((double) fSize / 72) * 96 * 5) ;
        } else {
            fPix = (int) (((double) fSize / 72) * 96) + 10;
        }

        yAxis.gethTitle()
                .setOffset(new Dimension((int) (fPix - canvasWidth * px), canvasHeight / 2 - 10));

        // ラベルフォマード
        NumericFormat nFormat = new NumericFormat();
        nFormat.setFormat('\0', false, 0, 0, 0, 0, '.', '\0', false);
        yAxis.setLabelFormat(nFormat);

        // Y軸描画カスタマイズ設定
        if (model == 1) {
            axisCustomize(chart, yAxis, 281.0, 171.0, 14.0, IHorzVertLine.HORIZONTAL_LINE,
                    Line.DOTTED, false, true, "(cm)");
        } else {
            axisCustomize(chart, yAxis, 52.3, 51.9, 0.1, IHorzVertLine.HORIZONTAL_LINE, Line.DOTTED,
                    true, true, "(kg)");
        }
        yAxis.setArrowhead(false);

        // データポイント設定
        IDataPointSet pointSet = chart.gethDataPoints();
        // ポイントを表示にする
        pointSet.setPointsVisible(true);
        // 色設定
        Color pointColor = new Color(51, 102, 255);
        Color[] colors = {pointColor};
        pointSet.setColors(colors);
        // ラインの幅設定
        int[] lineWh = {2};
        pointSet.setDataLineThickness(lineWh);
        // データビューグラフシンボル設定
        int[] shape = {QbChart.SQUARE};
        pointSet.setPointShapes(shape);
        int[] shapeSize = {5};
        pointSet.setPointSizes(shapeSize);
        // ポイントラベル設定
        ILabel label = pointSet.gethLabel();
        label.setVisible(true);
        label.setOffset(new Dimension(15, -15));

        // チャートをPNGデータに変換する
        ByteArrayOutputStream chartBytes = new ByteArrayOutputStream();

        // Show chart in Viewer
        try {
            chart.export(QbChart.PNG, chartBytes);
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        return chartBytes.toByteArray();
    }

    /**
     * X軸ステップ設定
     *
     * @param step
     */
    private void trikerAndLabelStep(IAxis axis, int step) {
        axis.setTickerStep(step);
        axis.setLabelStep(step);
    }

    /**
     * Y軸描画（カスタマイズ）
     *
     * @param chart
     * @param axis
     * @param maxVaule
     * @param minValue
     * @param step
     * @param line
     * @param lineStyle
     * @param isSetMaxLabel
     * @param isDecimal
     * @param title
     */
    private void axisCustomize(QbChart chart, IAxis axis, Number maxVaule, Number minValue,
            Number step, int line, int lineStyle, boolean isSetMaxLabel, boolean isDecimal,
            String title) {

        // XY軸表示の範囲手動設定（自動設定をOFF）
        axis.setScaleAutomatic(false);
        // 最大値設定
        axis.setMaxScale(maxVaule);
        // 最小値設定
        axis.setMinScale(minValue);
        // 間隔設定
        axis.setScaleStep(step);
        // ラベル格納
        String[] curLabels = new String[100];
        // 点線描画
        double curValue = minValue.doubleValue();
        int index = 0;
        while (curValue < maxVaule.doubleValue()) {
            IHorzVertLine hLine = chart.gethDataLines().newHorzVertLine(line, null);
            hLine.setLineValue(curValue);
            hLine.setLineStyle(lineStyle);
            chart.gethDataLines().add(hLine);

            // ラベル設定
            curLabels[index] =
                    isDecimal ? String.valueOf(curValue) : String.valueOf((int) curValue);

            curValue = curValue + step.doubleValue();
            index++;
        }
        if (isSetMaxLabel) {
            // 最大値のラベル設定
            curLabels[index] = isDecimal ? String.valueOf(maxVaule.doubleValue())
                    : String.valueOf(maxVaule.intValue());
        } else {
            // 最大値のラベル設定
            curLabels[index] = " ";
        }

        // ラベル描画
        axis.setTickerLabels(curLabels);

        // y軸タイトル設定
        axis.gethTitle().setValue(title);
    }
}
