import java.util.*;
class Main
{ 
static int dayofweek(int d, int m, int y) 
{ 
	int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 }; 
	y -= (m < 3) ? 1 : 0; 
	return ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7; 
} 

static String[] days={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
static class ans{
    String Date;
    String day;
    int sum;
    boolean flag;
    ans(String Date,String Day,int sum){
        this.Date=Date;
        this.day=Day;
        this.sum=sum;
        this.flag=false;
    }
}
public static void main(String arg[]) 
{ 
	HashMap<String,Integer> hm=new HashMap<>();
	hm.put("2020-01-01",4);//wed
	hm.put("2020-01-02",4);
	hm.put("2020-01-03",6);
	hm.put("2020-01-04",8);
	hm.put("2020-01-05",2);
	hm.put("2020-01-06",-6);
	hm.put("2020-01-07",2);
	hm.put("2020-01-08",-2); 
	HashMap<ans,Integer> tmp=new HashMap<>();
	for(String d:hm.keySet()){
	    String[] ch=d.split("-");
	    int x=dayofweek(Integer.parseInt(ch[2]),Integer.parseInt(ch[1]),Integer.parseInt(ch[0]));
	    ans Node=new ans(d,days[x],hm.get(d));
	    tmp.put(Node,1);
	}
	HashMap<ans,Integer> copy=new HashMap<>(tmp);
	for(ans n:tmp.keySet()){
	    if(n.flag){
	        continue;
	    }else{
	    for(ans k:copy.keySet()){
	        if(n.day==k.day&&k.flag==false){
	            n.sum+=k.sum;
	            k.flag=true;
	        }
	    }
	    n.flag=true;
	    }
	}
	for(ans l:tmp.keySet()){
	    System.out.print(l.day+" :"+l.sum);
	}
} 
}