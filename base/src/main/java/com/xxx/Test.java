package com.xxx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by Richard on 14-11-19.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.process(args[0],args[1]);
    }

    public void process(String srcPath,String destPath) {
        String[] infos = info.split("\n");
        for (int i = 0; i < infos.length; i++) {
            String item = infos[i];
            String[] details = item.split("\t");
            fileChannelCopy(new File(srcPath+"/"+details[1]),new File(destPath+"/"+details[0]+"_正.jpg"));
            fileChannelCopy(new File(srcPath+"/"+details[2]),new File(destPath+"/"+details[0]+"_反.jpg"));
        }
    }

    public void fileChannelCopy(File s, File t) {
        if(!s.exists()) {
            return;
        }
        System.out.println(s.getAbsolutePath()+"------>"+t.getAbsolutePath());
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String info = "362326197805010018\t25r7r5AaVxL7.jpg\tHQAogNhllds5.jpg\n" +
            "410327198810087670\t1IFLIH2sV2Ju.jpg\t22IfA3VbL30O.jpg\n" +
            "360102197711254341\tWinPbB8o49pQ.jpg\timTEzJ97TL30.jpg\n" +
            "320923199007026043\tC0Gj3j2A6wU8.jpg\tcniE56Imd6z8.jpg\n" +
            "320382198402215234\tz8Vg8hsUHizH.jpg\tILtg8nVfTaph.jpg\n" +
            "421125198507210022\tctegwBdCKCGH.jpg\t1kfIpyDBwYQ2.jpg\n" +
            "35262419810705671X\tgz2YqKgPTqmC.jpg\trn2AaQZdANpn.jpg\n" +
            "360426197708041713\tScBJu3ezkckS.jpg\tC0hXTdS3c8qK.jpg\n" +
            "310104198208312469\tPxbn06uD4BMN.jpg\t94gWSpNz6yaD.jpg\n" +
            "310109198006250839\tx0QIvkli3E25.jpg\tPUYPKSROZZEi.jpg\n" +
            "420104198501212032\tf8hct2VUzbjM.jpg\tUawcOW9uoPHS.jpg\n" +
            "430602197905010025\tshudsrsLwUZX.jpg\tO31koWTHgXur.jpg\n" +
            "110106198109063650\t4nceblMrNoq6.jpg\tn4xpnDZQAfOa.jpg\n" +
            "445281199001211552\tgT2XDI5Qk2iE.jpg\tfQtYApbwF87L.jpg\n" +
            "320525198012195315\tlDnpC3gVMxuy.jpg\tx3QipcDz9KNy.jpg\n" +
            "320219198209105797\tvT0mboYUrXEE.jpg\th6knWy9SL0Fy.jpg\n" +
            "110108197605241434\tpnvhKtpxx8wA.jpg\ttZyo6bwypOmX.jpg\n" +
            "370613198705201510\tmFBMYgCI1CzA.jpg\towac3wh9dM6W.jpg\n" +
            "31010519850819283X\tJcYH76hcKEM4.jpg\t2a7eGZolGRZW.jpg\n" +
            "511202198304011317\tChROC09TSdYa.jpg\tJIdjcHrkoHxL.jpg\n" +
            "310110198603255123\tcJE5FZJCRZCH.jpg\tJRfBwUSTvjzH.jpg\n" +
            "310115198902232919\t483Y6Td7uQcy.jpg\toKhOpLoVH3XW.jpg\n" +
            "321084198811132816\tSglNWd75WcRB.jpg\tktytWKFBtNf9.jpg\n" +
            "411282198508171513\tliDdDKYFvZbA.jpg\tRJKPZoyELCMB.jpg\n" +
            "341221198607016470\tmnIlfTiceywa.jpg\tztGxjneTnAM5.jpg\n" +
            "220421198905153724\t2ALC7ZlHZZnh.jpg\tid7wE604F3Eh.jpg\n" +
            "342422199201060159\tndf5QS8KkHBi.jpg\tbWI5F69ZmMv9.jpg\n" +
            "320924198210044839\t7BkGGTCsyE8o.jpg\taKU15ZpCVEnR.jpg\n" +
            "441481199201070018\tCsiWM4xjzLvY.jpg\tMk4EgysxCZWk.jpg\n" +
            "441223198806084448\tdw2n2KBtxic2.jpg\tnZJTBNs4t4WV.jpg\n" +
            "44092319841022574X\tg7CVyBQT74H1.jpg\tGBhtnYEDjgq6.jpg\n" +
            "440923198212155816\txs3BnSfSaXRY.jpg\tIXj7R2uqpJJP.jpg\n" +
            "520103198311300012\tLjU1sSdWvDma.jpg\tRnKOnMnlAOdC.jpg\n" +
            "36230119851121002X\tOZ1qkZJH8Xw2.jpg\t1XdF3E3tQhBT.jpg\n" +
            "420683198802090916\tJ2gHot5dfT5B.jpg\tBx4ISIvDByyV.jpg\n" +
            "130434199409171629\tGnv4c9Yf7zVy.jpg\tb9mITVd2yw9G.jpg\n" +
            "410482199006051030\trpgDw5BcceW1.jpg\tEzcnZl2mCaK4.jpg\n" +
            "520102198505090416\t4VCTuViYnbAp.jpg\tRisT8Xh7Hy1u.jpg\n" +
            "440921199110065416\t27roOlrdOine.jpg\t0FMaU4n2u09s.jpg\n" +
            "110105198611187118\tQrIUT0sunK7v.jpg\tgFlcP2el514a.jpg\n" +
            "320705199205123529\tqf5sVRGXm0ds.jpg\th5sXV8zDK7bj.jpg\n" +
            "230402197801020116\tilny4hcTgmtJ.jpg\txmcgAgPCYIWu.jpg\n" +
            "522701199001010315\tea7XBKwI4eV4.jpg\tTTBnTMTmazw0.jpg\n" +
            "440902198801090414\tvV9xeuNw43cl.jpg\tHDZsQ66B0jaJ.jpg\n" +
            "440103197812165125\tBgBmrPyvZd40.jpg\tx8xyQS4A630z.jpg\n" +
            "310225199102143419\tu88XIgsHFrUO.jpg\txNnnSiZLVaUC.jpg\n" +
            "450521198507044811\tVJDfhANBnG6q.jpg\tyiBN0nSbbeII.jpg\n" +
            "433130199008132313\tuHjLzyOYYmoZ.jpg\tvgLKRYLye2TI.jpg\n" +
            "230204198312280212\tTHk0OPVHx0IX.jpg\tQ0KDKJCPrWiI.jpg\n" +
            "43052419881222745X\tpaIkrE4SDKXw.jpg\tROI3tTqFvSYv.jpg\n" +
            "420624198506067631\tMlxNzJRCB5oY.jpg\tDU4gqOBT8GHF.jpg\n" +
            "421024198502230057\tQaUYrtVhtPx8.jpg\tM07uW9kyFNMC.jpg\n" +
            "440823198111080012\t0pUYQAccD9cR.jpg\tx8JXFXEeWONz.jpg\n" +
            "320911198105285313\t7ENC3vnjgz8B.jpg\twOxcMsRHkJFv.jpg\n" +
            "430381199311147831\tUTv69MsEr2Lm.jpg\tev817afFaqZd.jpg\n" +
            "310109198112233530\tJccs0dnFQp9x.jpg\tbvESIDj7vfIu.jpg\n" +
            "330482198204052419\tej8sd0g52RuX.jpg\tLjUpTPtbs3vT.jpg\n" +
            "321024197508244822\tUrF7Cwy3P7Fe.jpg\t6CYUy0Xp9Ymi.jpg\n" +
            "320830198710016633\tWJ7nunBfoRz1.jpg\tZLC7oJFNDQw7.jpg\n" +
            "31011319880302197X\tZZkeh5iz9Kwz.jpg\tHVTKB3Jt9Hkd.jpg\n" +
            "440783198302022019\tv0UmkLWvRHso.jpg\tWbp21KfVKFvP.jpg\n" +
            "321322198806090612\t5MBfP4sNTiqM.jpg\taMf9IV6x1A0O.jpg\n" +
            "513001199008282429\t7Y1c9ZL8esr6.jpg\thcHvQw5octwa.jpg\n" +
            "441322198401020218\t7Qt3hv073AdH.jpg\t91vECdll3Hcb.jpg\n" +
            "320831198112291017\tLEHRnVnAzdJy.jpg\tbOJeiFli3KEY.jpg\n" +
            "360721198811103264\tquW9mHxQArZE.jpg\t6a8p2qoHqNHK.jpg\n" +
            "130684198007014516\tnr59RIgPgQ0m.jpg\t2MqpwbknH0BL.jpg\n" +
            "362103198303204110\tdG0EM7SB7BFE.jpg\tF5fJk3vLSu43.jpg\n" +
            "320901198112310019\t2TThgIRXWMkU.jpg\tdX1YGBk7kaTG.jpg\n" +
            "45072119840510532X\tykiZUqv8mot0.jpg\tYkd4SHDl3mlC.jpg\n" +
            "41270219920805501X\t2Y5s1BwCNXxr.jpg\tOiGhXerssoSw.jpg\n" +
            "341623198512246710\tJVQYHjAgCk4s.jpg\tcq9ckhkBDkFY.jpg\n" +
            "440921198410263831\t1ix5fhqTK85F.jpg\tN2sBnBE77aP6.jpg\n" +
            "452133198709180331\thj1i0kQbwo3J.jpg\trqSROTYUQtK0.jpg\n" +
            "440125197608124447\tPYwxfSna9XFj.jpg\tTL573zCcYnpV.jpg\n" +
            "420529198406141212\tbuwU0tYMPPSb.jpg\tEpTBLfCuolEI.jpg\n" +
            "320982199111220073\tVYt6Nl0OwBoQ.jpg\tZEFjZ7zUtsoB.jpg\n" +
            "310226198807244721\t51q9wKC04bs8.jpg\t134shmPJh4vv.jpg\n" +
            "310103198911215031\tSGI7X7XKBPG3.jpg\tpP75zvLUcGRy.jpg\n" +
            "130705198909021547\tgCNaWLNQwrJN.jpg\t1xxUyl8hUllH.jpg\n" +
            "440582199405043645\tIOEacymjtYse.jpg\trkSjoo3gTBCJ.jpg\n" +
            "442531196809012325\ta8sVGDcZqYHe.jpg\tvPXBAkgtmKKv.jpg\n" +
            "132827196712062018\tzDVdCKCLd3Tp.jpg\t0DXGhSoRuo8g.jpg\n" +
            "370403198709120730\t2a4YIZOJiMsK.jpg\tzBqmZ4ohPGpJ.jpg\n" +
            "421181199108147025\tb4YeDFwfR4TD.jpg\tWjhFCTVmVHII.jpg\n" +
            "500226198706171119\tfXoBCqOeYhd9.jpg\tliejXBncVqgo.jpg\n" +
            "61252419880417041X\tbfFFhFedyGfE.jpg\tBFUSBNkLvo5V.jpg\n" +
            "440181199202220957\tmsan5uJ2vMPk.jpg\ty0qHFx9V4Tnf.jpg\n" +
            "445222198310030056\tNLhEaOOLxVXa.jpg\tKEsUa6wAnGhZ.jpg\n" +
            "130224198103026818\tvcmh7nr68sA0.jpg\tISSZOUPTjx2k.jpg\n" +
            "422322198406236613\tehgZxj6VHUqr.jpg\t0hweHbTH0Qsv.jpg\n" +
            "342423197705026285\tbEjaE4BgdyAN.jpg\tu0TbYb6qFzuD.jpg\n" +
            "500101198711296730\tDobLkLib7gKL.jpg\tZYVH2JZfZxzN.jpg\n" +
            "42230219860121254X\tNWv72Zcfdw8Y.jpg\tG8zvS5jWjNtm.jpg\n" +
            "310115198710310193\ts2DcncaBp65B.jpg\toib24RMARrIi.jpg\n" +
            "432925198112285317\t7VY6sjMlPUgx.jpg\tBaH0koumzVNc.jpg\n" +
            "15042919770211343x\t1U2aIgdSF7pQ.jpg\thWkP4xbp5DU8.jpg\n" +
            "110224197601180510\tzUbFDUXaOp41.jpg\tPqv3TYacrrkS.jpg\n" +
            "150426199101031375\tynn6Yo685dxb.jpg\tOS0ZsZvE9Cl2.jpg\n" +
            "410521198501104556\tEhfxLzH19a98.jpg\tDlZ49U8tNz3J.jpg\n" +
            "440921198108285730\tmOweDEsoptTo.jpg\tYBvtolrb4aDM.jpg\n" +
            "362425198509031010\tt2ZDYAOoIUDB.jpg\tpiQK8PacgQha.jpg\n" +
            "430124198411125311\tdUwSXOSJ4kXC.jpg\t0Ar574iDAFzV.jpg\n" +
            "441624198810066152\tDRllx53wJY6F.jpg\tml7od6GFvS1r.jpg\n" +
            "230207198808100616\tzckP1s6qzMyd.jpg\tH4urFG3HkA5m.jpg\n" +
            "422226197801110012\tU41b3tkbfhlQ.jpg\tMNjWqbc3PbBi.jpg\n" +
            "411381198812025923\tPQ3tuepfWKrA.jpg\tN3MBrOwnLf1q.jpg\n" +
            "430529199206196266\tEgJGgJWDVzau.jpg\tucMk54I2tqLn.jpg\n" +
            "44528119930812375X\tNZWz5KIDbR40.jpg\tguh2qwsHec7y.jpg\n" +
            "230105199207073946\tTOrxNd1chBOF.jpg\taWojy01QLzCn.jpg\n" +
            "352202199003170010\tmi6oAdwcVIlG.jpg\t4zTzY60Gb8BB.jpg\n" +
            "130603198402100029\tbG3q9m067nwa.jpg\t8gCVLWXTS4PN.jpg\n" +
            "230207197601300616\tFqKlTE1JGiaa.jpg\tBG2kbBtYETLj.jpg\n" +
            "440301199101254110\tG9hURnHYUE5z.jpg\tf2ldl5AwW1dU.jpg\n" +
            "450881198702010919\tL0O7zosIIHBb.jpg\tPMcUtvCr5gGw.jpg\n" +
            "37290119891106787X\tOXOjy2A8umr4.jpg\thoInEuX6sCal.jpg\n" +
            "222426199001202325\t4Ltl3oKBthdv.jpg\tjU7ExbDxEBtg.jpg\n" +
            "220802199004281531\taEuxvlgY8HzV.jpg\twjj6JsrWNvCb.jpg\n" +
            "441522198802140633\tTq4cUXs7z0TD.jpg\t5nRzvCwUMU68.jpg\n" +
            "450923198908207313\tuSzFUjAASu3E.jpg\tI5YxNOGOkUjR.jpg\n" +
            "330382198910231419\tpqYqME3LuJbu.jpg\trDnXwg9aeo1i.jpg\n" +
            "420322198402030317\tYVkMBN4vO1GP.jpg\tTbUrjLtgMu7G.jpg\n" +
            "360721198611107236\tHbjg7jthS1Ya.jpg\tvX7vAE3LDafy.jpg\n" +
            "341125198611165970\t1EWP27ktay16.jpg\tVeZkMXKBFjtT.jpg\n" +
            "310115197907093212\thwFVEhGA2qUl.jpg\toH2KgGpoeR7s.jpg\n" +
            "430521199407171689\tjSW4uklwhqNt.jpg\toOyuoMPQkTF1.jpg\n" +
            "450881198809103277\tZERRG9WZQju7.jpg\tNUY02awwGhoh.jpg\n" +
            "450981199308071457\tWvgVNR6Ko9ak.jpg\tdGKHoNxskuXA.jpg\n" +
            "34082819870725013X\tYniqCxVdi6jm.jpg\tZdxRh9Eyogpz.jpg\n" +
            "441421198705032794\td9JhKFFjy27g.jpg\tUufM0hXBvNkA.jpg\n" +
            "331023198701126617\tZZQrpNJchcke.jpg\t7NG5YB1f2NTk.jpg\n" +
            "410182198203260711\tAVeIqafVXMUS.jpg\tFNkjV3jdrbcb.jpg\n" +
            "452622199110290027\t0vdiy1cekHYC.jpg\t08eOUR1adtQQ.jpg\n" +
            "432502198702186515\tYCg4JaDLKbH8.jpg\tL0g3zKhtPR12.jpg\n" +
            "441522198206045752\tHYhMGs9u4TLO.jpg\tLrEOA5yftTTj.jpg\n" +
            "440204197611104432\tj55DmAmsf2l1.jpg\tXRqRDXGWdoAe.jpg\n" +
            "231003197908202011\tNHrdXCrIbilF.jpg\tutXgJIwlSSir.jpg\n" +
            "33262519791210222X\tFLrHadSGnvKQ.jpg\tcclw0noG8FPm.jpg\n" +
            "450421199101203527\t9y9Tzx888Adu.jpg\tjnLZfIGVnOlU.jpg\n" +
            "441821198405181511\tpzshP0HO2RmW.jpg\to46hFqLcRm4g.jpg\n" +
            "441224198501073779\tfBXvVm6gdC6L.jpg\tqKJl8uajNYiz.jpg\n" +
            "420682198412144513\tYCKbyrU9X3TL.jpg\tEWNsjGHcfWTe.jpg\n" +
            "440582198504282073\tRgFxcCN1HohF.jpg\taf5SD0hqbGTT.jpg\n" +
            "410203197709052018\tJPFTIdKh2bwl.jpg\twJ056SpFrTNo.jpg\n" +
            "110102198108082715\tC23f6BdWViym.jpg\tQQhPRqNjDzsx.jpg\n" +
            "440982198902103431\tDgrpdGs3BnPN.jpg\tLCq9pyT2laPM.jpg\n" +
            "411082198505120613\t9VSAnN6aRZ8P.jpg\t8YloorcBOJ0x.jpg\n" +
            "371202198504271811\tWULWjXCpPynD.jpg\tkMrHGs5bOAqQ.jpg\n" +
            "440507198910251627\tvHJ9dKImrl0G.jpg\trTy2JhXMLIvn.jpg\n" +
            "421124199002141023\tfNtDJ62yNMu2.jpg\tzSImZqV8O6Em.jpg\n" +
            "150423198601294418\ttISVdYLgDhlp.jpg\twCa2WnekOdXF.jpg\n" +
            "610502198303020616\tlaSbgZdV3nat.jpg\tK5fGNfCWSQLm.jpg\n" +
            "310104196711242438\tlZL70uO6oLnu.jpg\tY1ZDAuw5xX4e.jpg\n" +
            "440181198412143019\tJcEIEjCtj7Yj.jpg\t5qrMszm4q1al.jpg\n" +
            "440882198510024034\tFhU9ZeXi2k0D.jpg\tzzwNpFgQ8mG1.jpg\n" +
            "441823198901157054\tPwHgAbuRWY50.jpg\tzk7gv49WJe3q.jpg\n" +
            "110111198810074033\tQpPaVQeWHoPW.jpg\tGHJzzacRokUC.jpg\n" +
            "440881199009020011\tww0FD7rUoYYm.jpg\tiJmSEPhtziAp.jpg\n" +
            "110223198305295311\t5ZLt2WTi13ub.jpg\t24enjVQ1FhzO.jpg\n" +
            "110106197712153621\tA1w2OxJs9oAz.jpg\tRvWmARiyzbvr.jpg\n" +
            "110111199101158650\t9md6eJSgvdgi.jpg\tjh1BJoENWV5Z.jpg\n" +
            "370403198701154119\tGovi3EESgA07.jpg\tyhm3ZSZVFNUu.jpg\n" +
            "360424198711201310\tZOOsDffmFAkT.jpg\toEPIWmdnHdOx.jpg\n" +
            "441424198209194857\tFw5Qo5fdhgY5.jpg\tKwka8QDcSHtU.jpg\n" +
            "310110198407125196\tOB4owGEcwchZ.jpg\tJ0nDtK8oTwwS.jpg\n" +
            "513401198711284220\t0C4jxr7EBngr.jpg\tVWHPSDDnxzFJ.jpg\n" +
            "130582198307230626\tzDY1MXFLjsgC.jpg\tYWuqX87iDCqR.jpg\n" +
            "610124198704160034\tHmNIoCDXeko6.jpg\tY7iqRSeKMgV4.jpg\n" +
            "429006198301225432\tYM60yuu5hmAC.jpg\tJuB4HIUKLd6T.jpg\n" +
            "440301197709124630\t0R0T6sP9TDyR.jpg\tUNq4mUqo6UEW.jpg\n" +
            "130982198710101973\tRLnKBFw3j7Lz.jpg\tqDBjnLKXqqXE.jpg\n" +
            "450322198410203025\tjmbi4DuW4cLf.jpg\tJaTp8cfrUj1w.jpg\n" +
            "430528199009153818\t3VtRS6TETzob.jpg\t7cvzsonGhvUr.jpg\n" +
            "440182199107020013\tQgPSIHAAFVMS.jpg\twF1uxkYGxmPx.jpg\n" +
            "43052719930321091X\tP7ysjmd1LgpQ.jpg\tSBhzOnwL46eV.jpg\n" +
            "430903198311031811\t6GcZxJoyM1tr.jpg\tdWwtqNAEZUiE.jpg\n" +
            "440106199406135615\tz4doFhdpampM.jpg\tWru9mwLikUw6.jpg\n" +
            "450324198406180724\t4uy4qyDk3DU0.jpg\t8smqu8ZoyVca.jpg\n" +
            "430523198908237234\tRTnPiKRL770N.jpg\tOIZLLi1muCxm.jpg\n" +
            "445281199207131515\tbzZIg9nRKW7k.jpg\tXrfFL233y7My.jpg\n" +
            "441224199009122617\tWQSi338qX3YC.jpg\tzJJcEfnrNC6R.jpg\n" +
            "440825199103160060\twkYObPxYttSI.jpg\tj3cG5r827qNK.jpg\n" +
            "340321198909197638\tpq9MN0txvbKz.jpg\t7Zw9llqHqXsu.jpg\n" +
            "342123197903054969\t4XsdTSUfnTPR.jpg\tlxWiT2cUvSza.jpg\n" +
            "130821197512102710\t0nh1X4VcYPxh.jpg\tKy1ocytlXgQf.jpg\n" +
            "410322197506182837\tAeuGBwfmpcRR.jpg\t2wNquD4k1QeV.jpg\n" +
            "441422198909051336\tb78mWSoHrRWr.jpg\t407MZoWqvF5c.jpg\n" +
            "320125198212254330\t1EqExylS8Bpo.jpg\tSghWCrEml6Du.jpg\n" +
            "352225198703152577\tKSGeWADLODcz.jpg\tXJmH2H3aq85O.jpg\n" +
            "511324198101190670\to4ngJDETP4WX.jpg\tEhRj3kHRI2vl.jpg\n" +
            "450121198906261520\tWO2NqIXDYUsk.jpg\tqB7n9JG09PgG.jpg\n" +
            "360731199010156590\tlESu7uVX2n3B.jpg\tNkIGbE1bKjaN.jpg\n" +
            "640202197507140550\tAoQos632bNSD.jpg\toKG85vfMlOET.jpg\n" +
            "310108198401111517\t8sKx2wKQb9lh.jpg\tKYNuE9D6yKCo.jpg\n" +
            "110227198208165318\tb0XAemsebOEb.jpg\tn1zk7qUTkVn7.jpg\n" +
            "430481199302038997\taHd234sR9Dni.jpg\tcIKSDH96vAsd.jpg\n" +
            "362427199007202550\tkO9Ny1SBSuKv.jpg\t5COGBtL4s1UG.jpg\n" +
            "220723198807011625\tIptIGbqHPXHe.jpg\t0kpRaMAtbuL8.jpg\n" +
            "36072719890821281X\tgSOakIZMbm0J.jpg\tFKJ2D6Hg9vUl.jpg\n" +
            "612430199109260719\tYXFjlxDD5Bv8.jpg\tUYyhcCkw3ciw.jpg\n" +
            "421087198904302127\t4ogRDqTuiAlg.jpg\tJzt0YmjqQTrS.jpg\n";
}
