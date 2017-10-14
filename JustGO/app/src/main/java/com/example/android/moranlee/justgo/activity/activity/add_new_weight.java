package com.example.android.moranlee.justgo.activity.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.android.moranlee.justgo.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class add_new_weight extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        GraphView graph = (GraphView) findViewById(R.id.weight_graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 3),
                new DataPoint(1, 3),
                new DataPoint(2, 6),
                new DataPoint(3, 2),
                new DataPoint(4, 5)
        });
        graph.addSeries(series2);

// legend
        series.setTitle("user's weight change");
        series2.setTitle("user's height change");
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

    }


}
