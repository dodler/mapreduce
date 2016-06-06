package com.company;

import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

/**
 * Created by arli on 6/6/16.
 */
public class CustomMapper extends MapReduceBase implements Mapper {

    @Override
    public void map(Object o, Object o2, OutputCollector outputCollector, Reporter reporter) throws IOException {

    }
}
