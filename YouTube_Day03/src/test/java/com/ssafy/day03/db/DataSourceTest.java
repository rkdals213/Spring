package com.ssafy.day03.db;

import java.sql.Connection;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	
   @Autowired
   private DataSource ds;//기본값 ds=null;
   
   @Test
   public void testConnection() throws Exception{
	   Connection conn = ds.getConnection();
	   System.out.println("DBCP DB연결성공==>"+ conn);
   }   
}


