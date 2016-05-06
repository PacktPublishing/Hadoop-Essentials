public class PrimeNumberBolt extends BaseRichBolt 
{
    private OutputCollector collector;

    public void prepare( Map conf, TopologyContext context, OutputCollector collector ) 
    {
        this.collector = collector;
    }

    public void execute( Tuple tuple ) 
    {
        int number = tuple.getInteger( 0 );
        if( isPrime( number) )
        {
            System.out.println( number );
        }
        collector.ack( tuple );
    }

    public void declareOutputFields( OutputFieldsDeclarer declarer ) 
    {
        declarer.declare( new Fields( "number" ) );
    }   
    
    private boolean isPrime( int n ) 
    {
        if( n == 1 || n == 2 || n == 3 )
        {
            return true;
        }
        
        // Is n an even number?
        if( n % 2 == 0 )
        {
            return false;
        }
        
        //if not, then just check the odds
        for( int i=3; i*i<=n; i+=2 ) 
        {
            if( n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
