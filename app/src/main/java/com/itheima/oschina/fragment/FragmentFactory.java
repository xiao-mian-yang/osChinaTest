package com.itheima.oschina.fragment;

import java.util.HashMap;

/**
 * Created by 吴广东 on 2016/9/4.
 */
public class FragmentFactory {
    private static final int zongshu = 0;
    private static final int dongdan = 1;
    private static final int faxain = 2;
    private  static final int tuijian=3;
    private static final int MAX_SIZE = 4;

    private static HashMap<Integer, BaseFragment> spagers = new HashMap<Integer, BaseFragment>();
    public static BaseFragment create(int position) {
        BaseFragment f = spagers.get(position);


        if (f != null) {
            return f;
        } else {


            switch (position) {
                case zongshu:
                    f = new Consultfragment();
                    break;

                case dongdan:
                    f = new HotFragment();
                    break;

                case faxain:
                    f = new Blogfragment();
                    break;
                case tuijian:
                    f = new recommandFragment();
                    break;


            }
            spagers.put(position, f);
        }
            return f;
        }

    /**
     * 返回数量
     * @return
     */
    public  static int getSize(){

        return  MAX_SIZE;
       }
    }
