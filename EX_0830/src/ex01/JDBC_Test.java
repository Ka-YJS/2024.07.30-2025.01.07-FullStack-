package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC_Test {
	public static void main(String[] args) {
		
		/*
		-Oracle데이터베이스와 Java 어플리케이션 간의 연결을 제공하는
		JDBC드라이버 클래스 OracleDriver는 Oracle데이터베이스와
		상호작용하고, 데이터베이스 연결 및 쿼리 실행을 처리하는 Java어플리케이션에 사용됨
		-Oracle 데이터베이스와의 통신을 담당하며, Java코드가 Oracle데이터베이스와 상호작용을 할 수 있게 도와줌*/
		String driver = "oracle.jdbc.driver.OracleDriver";//어떤 driver인지 명시를 함
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		/*JDBC드라이버는 THIN방식과 OCI방식이 있음
		-THIN방식 : 순수하게 자바 패키지(클래스)만으로 바로 DB와 연결, 범용성이 높음
		-OCI방식 :  Oracle Call Interface 특정 운영체제내에서만 돌아가는 모듈을 통해 DB에 연결함*/
		String userID = "hr";
		String password = "hr";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			//url,아이디,비번가지고 DB에 연결
			con = DriverManager.getConnection(url,userID,password);
			
			//문자열로 된 쿼리문
			String sql = "SELECT * FROM DEPT2";
		//	String sql = "SELECT * FROM DEPT2 WHERE DEPNO = 10"; -> 10번에 대한 정보만 조회가능
			
			//문자열을 전달받아 실제 쿼리문으로 변경
			pstmt = con.prepareStatement(sql);
			
			//쿼리문 실행 후 rs객체에 저장
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno+"\t"+dname+"\t"+loc);
			}
			
		} catch (Exception e) {
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(con !=null) con.close();
			} catch (Exception e2) {
			}
		}
		
		
	}}
