package my;


public class myclass {
    public static void main(String[] args) {
        int data=50;
        System.out.println("Hi from myclass45");
        for (int i = 0; i < 20000; i++) {
              System.out.println("##teamcity[blockOpened name='"+i+"' description='"+i+"']");
            for (int j = 0; j < 20000; j++) {
          
        System.out.println(j + "..hi from ..hi from ..hi from ..hi from ..hi from ..hi from ..hi from ..hi from ..hi from ..hi from ..hi from ..hi from " + j);
               
}
             System.out.println("##teamcity[blockClose name='"+i+"']");
    }
    }
}


