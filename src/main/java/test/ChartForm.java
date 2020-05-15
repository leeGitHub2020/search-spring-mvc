package test;

import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

public class ChartForm implements Serializable{

    private  MultipartFile chartData;

    /**
     * chartDataを返却する。
     * @return chartData
     */
    public MultipartFile getChartData() {
        return chartData;
    }

    /**
     * chartDataをセットする。
     * @param  chartData
     */
    public void setChartData(MultipartFile chartData) {
        this.chartData = chartData;
    }
}
