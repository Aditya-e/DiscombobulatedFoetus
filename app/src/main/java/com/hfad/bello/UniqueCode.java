package com.hfad.bello;

public class UniqueCode {



    //static method to return unique code in String type
    public String uniqueCode(String uid)
    {
        long time=System.currentTimeMillis();

        StringBuffer s=new StringBuffer(uid);
        while(time>0)
        {
            int n=(int)time%10;
            char c;
            switch(n)
            {
                case 1:c='!';
                    break;
                case 2:c='*';
                    break;
                case 3:c='@';
                    break;
                case 4:c='&';
                    break;
                case 5:c='#';
                    break;
                case 6:c='^';
                    break;
                case 7:c='$';
                    break;
                case 8:c='%';
                    break;
                case 9:c='(';
                    break;
                default:c='z';
            }
            s=s.append(c);
            time/=10;
        }
        String code=s.toString();//code returns unique code in String type
        return code;
    }
}
