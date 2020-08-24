package com.dingzhen;

import com.dingzhen.entity.SysUser;
import com.dingzhen.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SpringbootMybatisMysqlApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    void testInsert() {


        ArrayList<SysUser> sysUsers=new ArrayList<>();
            for (int i = 0; i < 10000000; i++) {
                SysUser sysUser=new SysUser();
                sysUser.setUserId(String.valueOf(i));
                sysUser.setUserName("Jack"+i);
                sysUsers.add(sysUser);
            }
        int in=sysUserMapper.insert(sysUsers);
        System.err.println("插入："+in+"条");
//        for (int j = 0; j < 6; j++) {
//            long begintime1 = System.currentTimeMillis();
//            List<SysUser> sysUsers=new LinkedList<>();
//            for (int i = 0; i < 10000000; i++) {
//                SysUser sysUser=new SysUser();
//                sysUser.setUserId(String.valueOf(i));
//                sysUser.setUserName("Jack"+i);
//                sysUsers.add(sysUser);
//            }
//            long endtime1 = System.currentTimeMillis();
//            long costTime1 = ( endtime1 - begintime1 );
//            System.err.println( "LinkedList添加1千万耗时：===="+ costTime1);
//         /** 输出结果
//         * LinkedList添加1千万耗时：====25139
//         * LinkedList添加1千万耗时：====15277
//         * LinkedList添加1千万耗时：====14854
//         * LinkedList添加1千万耗时：====8703
//         * LinkedList添加1千万耗时：====8024
//         * LinkedList添加1千万耗时：====6056
//         */
//        }
//
//
//        for (int j = 0; j < 6; j++) {
//            long begintime1 = System.currentTimeMillis();
//            LinkedList<SysUser> sysUsers=new LinkedList<>();
//            for (int i = 0; i < 10000000; i++) {
//                SysUser sysUser=new SysUser();
//                sysUser.setUserId(String.valueOf(i));
//                sysUser.setUserName("Jack"+i);
//                sysUsers.add(sysUser);
//            }
//            long endtime1 = System.currentTimeMillis();
//            long costTime1 = ( endtime1 - begintime1 );
//            System.err.println( "LinkedList添加1千万耗时：===="+ costTime1);
//       /** 输出结果
//         * LinkedList添加1千万耗时：====26222
//         * LinkedList添加1千万耗时：====13749
//         * LinkedList添加1千万耗时：====13198
//         * LinkedList添加1千万耗时：====6671
//         * LinkedList添加1千万耗时：====4641
//         * LinkedList添加1千万耗时：====14262
//        */
//        }
//
//
//        for (int j = 0; j < 6; j++) {
//            long begintime2 = System.currentTimeMillis();
//            List<SysUser> sysUsers2 = new ArrayList<>(10000000);
//            for (int i = 0; i < 10000000; i++) {
//                SysUser sysUser2 = new SysUser();
//                sysUser2.setUserId(String.valueOf(i));
//                sysUser2.setUserName("Jack" + i);
//                sysUsers2.add(sysUser2);
//            }
//            long endtime2 = System.currentTimeMillis();
//            long costTime2 = (endtime2 - begintime2);
//            System.err.println("ArrayList 添加1千万耗时：====" + costTime2);
//         /**输出结果
//         * ArrayList 添加1千万耗时：====26965
//         * ArrayList 添加1千万耗时：====14188
//         * ArrayList 添加1千万耗时：====18912
//         * ArrayList 添加1千万耗时：====6923
//         * ArrayList 添加1千万耗时：====7898
//         * ArrayList 添加1千万耗时：====7939
//         */
//        }
//
//
//        for (int j = 0; j < 6; j++) {
//            long begintime2 = System.currentTimeMillis();
//            List<SysUser> sysUsers2 = new ArrayList<>();
//            for (int i = 0; i < 10000000; i++) {
//                SysUser sysUser2 = new SysUser();
//                sysUser2.setUserId(String.valueOf(i));
//                sysUser2.setUserName("Jack" + i);
//                sysUsers2.add(sysUser2);
//            }
//            long endtime2 = System.currentTimeMillis();
//            long costTime2 = (endtime2 - begintime2);
//            System.err.println("ArrayList 添加1千万耗时：====" + costTime2);
//            /**
//             * 输出结果
//             * ArrayList 添加1千万耗时：====18945
//             * ArrayList 添加1千万耗时：====12115
//             * ArrayList 添加1千万耗时：====7444
//             * ArrayList 添加1千万耗时：====10321
//             * ArrayList 添加1千万耗时：====8066
//             * ArrayList 添加1千万耗时：====11255
//             */
//        }
//        long begintime2 = System.currentTimeMillis();
//        ArrayList<SysUser> sysUsers2 = new ArrayList<>();
//        for (int i = 0; i < 100000000; i++) {
//            SysUser sysUser2 = new SysUser();
//            sysUser2.setUserId(String.valueOf(i));
//            sysUser2.setUserName("Jack" + i);
//            sysUsers2.add(sysUser2);
//        }
//        long endtime2 = System.currentTimeMillis();
//        long costTime2 = (endtime2 - begintime2);
//        System.err.println("ArrayList 添加1千万耗时：====" + costTime2);
//        for (int j = 0; j < 6; j++) {
//
//            /**
//             * 输出结果
//             * ArrayList 添加1千万耗时：====14385
//             * ArrayList 添加1千万耗时：====10888
//             * ArrayList 添加1千万耗时：====9748
//             * ArrayList 添加1千万耗时：====4664
//             * ArrayList 添加1千万耗时：====10691
//             * ArrayList 添加1千万耗时：====8972
//             */
//
//            long begintime3 = System.currentTimeMillis();
//            for (int i = 0; i < 100000000; i++) {
//                sysUsers2.get(i).getUserName();
//            }
//            long endtime3 = System.currentTimeMillis();
//            long costTime3 = (endtime3 - begintime3);
//            System.err.println("ArrayList for i 遍历1千万耗时：====" + costTime3);
//
//            long begintime4 = System.currentTimeMillis();
//            for (SysUser sysUser: sysUsers2
//            ) {
//                sysUser.getUserName();
//            }
//            long endtime4 = System.currentTimeMillis();
//            long costTime4 = (endtime4 - begintime4);
//            System.err.println("ArrayList foreach 遍历1千万耗时：====" + costTime4);
//
//            long begintime5 = System.currentTimeMillis();
//            sysUsers2.stream().forEach(p->{
//                p.getUserName();
//            });
//            long endtime5 = System.currentTimeMillis();
//            long costTime5 = (endtime5 - begintime5);
//            System.err.println("ArrayList stream 遍历1千万耗时：====" + costTime5);
//        }

    }
}
