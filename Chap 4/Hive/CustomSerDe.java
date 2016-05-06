public class CustomSerDe implements SerDe {
 
 private StructTypeInfo rowTypeInfo;
 private ObjectInspector rowOI;
 private List<String> colNames;
 Object[] outputFields;
 Text outputRowText;
 private List<Object> row = new ArrayList<Object>();
 
 @Override
 public void initialize(Configuration conf, Properties tbl)
     throws SerDeException {
   // Get a list of the table's column names.
   String colNamesStr = tbl.getProperty(Constants.LIST_COLUMNS);
   colNames = Arrays.asList(colNamesStr.split(","));
  
   // Get a list of TypeInfos for the columns. This list lines up with
   // the list of column names.
   String colTypesStr = tbl.getProperty(Constants.LIST_COLUMN_TYPES);
   List<TypeInfo> colTypes =
       TypeInfoUtils.getTypeInfosFromTypeString(colTypesStr);
  
   rowTypeInfo =
       (StructTypeInfo) TypeInfoFactory.getStructTypeInfo(colNames, colTypes);
   rowOI =
       TypeInfoUtils.getStandardJavaObjectInspectorFromTypeInfo(rowTypeInfo);
 }
 
 @Override
 public Object deserialize(Writable blob) throws SerDeException {
   row.clear();
   /* Implement the logic of Deserialization
   .
   .
   .*/
   
   return row;
 }
 
 @Override
 public ObjectInspector getObjectInspector() throws SerDeException {
   return rowOI;
 }
 
 @Override
 public SerDeStats getSerDeStats() {
   return null;
 }
 
 @Override
 public Class<? extends Writable> getSerializedClass() {
   return Text.class;
 }

 @Override
 public Writable serialize(Object obj, ObjectInspector oi)
     throws SerDeException {
   /* Implement Logic of Serialization 
   .
   .
   */
   
   return outputRowText;
 }
}
