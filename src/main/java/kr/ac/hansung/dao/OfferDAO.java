package kr.ac.hansung.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;


@Repository
public class OfferDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from scoreoffers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	//query and return a single object
	public Offer getOffer(String name) {
		String sqlStatement = "select * from scoreoffers where name=?";
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, 
				new RowMapper<Offer>(){
					
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Offer offer = new Offer();
						
						offer.setId(rs.getInt("id"));
						offer.setYear(rs.getInt("year"));
						offer.setTerm(rs.getInt("term"));
						offer.setCode(rs.getInt("code"));
						offer.setScore(rs.getInt("score"));
						offer.setSubject(rs.getString("subject"));
						offer.setPart(rs.getString("part"));
						
						/*offer.setName(rs.getString("name"));
						offer.setEmail(rs.getString("email"));
						offer.setText(rs.getString("text"));
						*/
						return offer;
						}
			
					}
				);
	}
	
	
	//query and return multiple objects
	public List<Offer> getOffers() {
		String sqlStatement = "select * from scoreoffers";
		
		return jdbcTemplate.query(sqlStatement, 
				new RowMapper<Offer>(){
					
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Offer offer = new Offer();
						
						offer.setId(rs.getInt("id"));
						offer.setYear(rs.getInt("year"));
						offer.setTerm(rs.getInt("term"));
						offer.setCode(rs.getInt("code"));
						offer.setScore(rs.getInt("score"));
						offer.setSubject(rs.getString("subject"));
						offer.setPart(rs.getString("part"));
						
					/*	offer.setName(rs.getString("name"));
						offer.setEmail(rs.getString("email"));
						offer.setText(rs.getString("text"));*/
						
						return offer;
						}
			
					}
				);
	}
	
	public boolean insert(Offer offer) {
				
		String subject = offer.getSubject();
		String part = offer.getPart();
		
		/*String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText()*/;
		
		String sqlStatement = "insert into scoreoffers (subject, part) values (?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {subject, part}) ==1);
		
		
	}
	
	
	
	
	public boolean update(Offer offer) {
		
		int id = offer.getId();
		String subject = offer.getSubject();
		String part = offer.getPart();

		
		String sqlStatement = "update scoreoffers set subject=?, part=? where id=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {subject, part, id}) ==1);
		
		
	}
	
	public boolean delete(int id) {
		String sqlStatement = "delete from scoreoffers where id=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {id}) ==1);
	}
	
}
