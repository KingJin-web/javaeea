package MySQL;

import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        DBHelper dbHelper = new DBHelper();
        //查询数据
        List<Map<String, Object>> list = dbHelper.query("select * from Student;");
        //UPDATE <表名> SET 字段 1=值 1 [,字段 2=值 2… ] [WHERE 子句 ]
        System.out.println(list);

        //修改数据
        String sql = "update Student set sex= ? where sno=?";
        dbHelper.update(sql,"女","1");
        List<Map<String, Object>> list2 = dbHelper.query("select * from Student;");
        System.out.println(list2);

        //增加数据INSERT INTO <表名> [ <列名1> [ , … <列名n>] ] VALUES (值1) [… , (值n) ];
        sql = "insert into Student (Sname, Sex, Sage, Sdept) values (?, ?, ?, ?)";
        dbHelper.update(sql,"蔡碧", "男", "12","CN");
        List<Map<String, Object>> list3 = dbHelper.query("select * from Student;");
        System.out.println(list3);

        //删除数据 DELETE FROM <表名> [WHERE 子句] [ORDER BY 子句] [LIMIT 子句]
        sql = "delete from Student where sno = ?";
        dbHelper.update(sql,2);
        List<Map<String, Object>> list4 = dbHelper.query("select * from Student;");
        System.out.println(list4);

    }

}
