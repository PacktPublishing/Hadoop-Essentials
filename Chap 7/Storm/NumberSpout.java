public class NumberSpout extends BaseRichSpout 
{
    private SpoutOutputCollector collector;
    
    private static int currentNumber = 1;
        
    @Override
    public void open( Map conf, TopologyContext context, SpoutOutputCollector collector ) 
    {
        this.collector = collector;
    }
    
    @Override
    public void nextTuple() 
    {
        // Emit the next number
        collector.emit( new Values( new Integer( currentNumber++ ) ) );
    }

    @Override
    public void ack(Object id) 
    {
    }

    @Override
    public void fail(Object id) 
    {
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) 
    {
        declarer.declare( new Fields( "number" ) );
    }
}
