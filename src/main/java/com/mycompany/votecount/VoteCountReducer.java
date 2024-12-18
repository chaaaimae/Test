package com.mycompany.votecount;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;

public class VoteCountReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
    @Override
    public void reduce(Text key,Iterable<IntWritable> values,Context output) throws IOException,InterruptedException{
    int voteCount =0;
    for(IntWritable value:values)
    {
    voteCount+=value.get();
    }
output.write(key,new IntWritable(voteCount));
}
}
