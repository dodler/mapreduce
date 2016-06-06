package com.company;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by arli on 6/6/16.
 */
public class CustomReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
        int maxAvg = 30;
        int val = Integer.MIN_VALUE;

        while(values.hasNext()){
            val = values.next().get();

            if (val > maxAvg){
                outputCollector.collect(key, new IntWritable(val));
            }

        }
    }
}
