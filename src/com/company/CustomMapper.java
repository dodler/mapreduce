package com.company;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by arli on 6/6/16.
 */
public class CustomMapper extends MapReduceBase implements
        Mapper <LongWritable, Text, Text, IntWritable>{

    @Override
    public void map(LongWritable longWritable, Text text, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
        String line = text.toString();
        String lastToken = "";
        StringTokenizer tokenizer = new StringTokenizer(line, "/t");

        String year = tokenizer.nextToken();

        while(tokenizer.hasMoreTokens()){
            lastToken = tokenizer.nextToken();
        }

        int avgPrice = Integer.parseInt(lastToken);
        outputCollector.collect(new Text(year), new IntWritable(avgPrice));
    }
}
