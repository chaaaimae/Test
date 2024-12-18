package com.mycompany.votecount;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class VoteCountMapper extends Mapper<Object,Text,Text,IntWritable>{
    private final static IntWritable one =new IntWritable(1);
    @Override 
    public void map(Object key,Text value,Context output) throws IOException,InterruptedException{
    String[] words = value.toString().split(" ");
    output.write(new Text(words[0]),one);
}
}
