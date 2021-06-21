package datastructures;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class kadane {

    static int maxSubArraySum(int a[])
    {
        String s = "";
        int size = a.length;
        int siz = 1;
        char  ab =  (char) siz;
        System.out.println(ab);
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;

    }
    public static void main (String[] args) throws UnknownHostException, NamingException {
        String s = "";
        int siz = 5;
        char  ab = (char) (siz + '0');
        System.out.println(ab);
        String myCNAME = "performancemanager4.successfactors.com";
        InetAddress inetAddress = InetAddress.getByName(myCNAME);
        System.out.printf("My hostname = '%s'", inetAddress.getCanonicalHostName());
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
        InitialDirContext idc = new InitialDirContext(env);
        Attributes attrs = idc.getAttributes("performancemanager4.successfactors.com", new String[]{"CNAME"});
        Attribute attr = attrs.get("CNAME");

        System.out.println(attr.get());
    }
}
