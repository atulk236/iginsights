package com.ueniweb.techsuperficial.iginsight.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Bar;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.HoverMode;
import com.ueniweb.techsuperficial.iginsight.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AgeRangeChartFragment extends Fragment {
    @BindView(R.id.chart)
    AnyChartView anyChart;

    public AgeRangeChartFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_age_range_chart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Cartesian vertical = AnyChart.vertical();
        List<DataEntry> data = new ArrayList<>();
        data.add(new CustomDataEntry("13-17", 50));
        data.add(new CustomDataEntry("18-24", 40));
        data.add(new CustomDataEntry("25-34", 26));
        Set set = Set.instantiate();
        set.data(data);
        Mapping barData = set.mapAs("{ x: 'x', value: 'value' }");
        Bar bar = vertical.bar(barData);
        bar.labels().format("");
        vertical.yScale().minimum(0d);
        vertical.labels(true);
        vertical.interactivity().hoverMode(HoverMode.BY_X);
        vertical.xAxis(true);
        vertical.yAxis(true);
        vertical.yAxis(0).labels().format("");
        anyChart.setChart(vertical);
    }

    private class CustomDataEntry extends ValueDataEntry {
        public CustomDataEntry(String x, Number value) {
            super(x, value);
        }
    }
}
