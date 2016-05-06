public class PrimeNumberTopology 
{
    public static void main(String[] args) 
    {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout( "spout", new NumberSpout() );
        builder.setBolt( "prime", new PrimeNumberBolt() )
                .shuffleGrouping("spout");


        Config conf = new Config();
        
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test", conf, builder.createTopology());
        Utils.sleep(10000);
        cluster.killTopology("test");
        cluster.shutdown();
    }
}
