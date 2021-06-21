package datastructures.graph;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RestClass {

    public static void main(String args[]) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode res = null;
        try{
            res =  objectMapper.readValue(
                    new File("/Users/i073413/SAPDevelop/workspace/response.txt"), JsonNode.class);

        }catch(Exception e){
            System.out.println("exception " + e);
        }

        JsonNode node = res.get("data");
       // System.out.println(" here "  + node.toPrettyString());
        Iterator  it = node.elements();
        while(it.hasNext()){
            JsonNode node1= (JsonNode)it.next();
            if(node1.get("employee_name") != null) {
                System.out.println(node1.get("employee_name"));
            }
         }

        Pattern pattern = Pattern.compile("a*\\[f");
        Matcher m = pattern.matcher("abc[def");
        System.out.println(m.find());
        List<Integer> x = new ArrayList();
        List newlist = x.stream().map(a -> a +1 ).collect(Collectors.toList());

        Scanner sc = new Scanner(new File("/Users/i073413/SAPDevelop/workspace/response.txt"));
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(s);
        }
        FileReader fr = new FileReader(new File("sdf"));
      //  fr.

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println(cal.get(Calendar.YEAR));
        cal.get(Calendar.HOUR);
        System.out.println(cal.get(Calendar.MINUTE));



        System.out.println(formatter.format(new Date()));




/**

        URL url  = new URL("https://api.careerbuilder.vn/general/industries");
       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       connection.setRequestMethod("GET");
       connection.setRequestProperty("language","en");
       connection.connect();
       connection.setConnectTimeout(1);
       System.out.println(" response " + connection.getResponseMessage());
       JsonNode node1 = objectMapper.readValue(connection.getInputStream(), JsonNode.class);
       //System.out.println(node1.toPrettyString());

       List<Industry> industries =
               (List<Industry>) objectMapper.readValue(node1.get("data").toString(),
                       new TypeReference<List<Industry>>() {
                       });
       System.out.println(industries);
 *
 */
    }


    class Response{

        Response(){

        }

        String success;
        List<Employee> data;

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public List<Employee> getData() {
            return data;
        }

        public void setData(List<Employee> data) {
            this.data = data;
        }
    }

    class Employee{
        int employee_age;
        int id;
        String employee_name;
        Double employee_salary;
        String profile_image;

        Employee(){

        }

        public int getEmployee_age() {
            return employee_age;
        }

        public void setEmployee_age(int employee_age) {
            this.employee_age = employee_age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmployee_name() {
            return employee_name;
        }

        public void setEmployee_name(String employee_name) {
            this.employee_name = employee_name;
        }

        public Double getEmployee_salary() {
            return employee_salary;
        }

        public void setEmployee_salary(Double employee_salary) {
            this.employee_salary = employee_salary;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }
    }
}
