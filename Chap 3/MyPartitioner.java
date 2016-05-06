public static class MyPartitioner extends   org.apache.hadoop.mapreduce.Partitioner<Text,Text>

{
  @Override
  public int getPartition(Text key, Text value, int numPartitions)
  {
   int count =Integer.parseInt(line[1]);
   if(count<=3)
    return 0;
   else
    return 1;
  }
}

// And in Driver class
// job.setPartitionerClass(MyPartitioner.class);
