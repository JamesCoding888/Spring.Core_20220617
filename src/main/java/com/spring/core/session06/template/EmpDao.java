package com.spring.core.session06.template;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.spring.core.session06.entity.Emp;
import com.spring.core.session06.entity.Job;
 
// Dao: Data Access Object
@Repository
public class EmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	// 多筆查詢 I
	public List<Map<String, Object>> queryAll() {
		String sql = "select eid, ename, age, createtime from web_springcore.emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}

	// 多筆查詢 II
	public List<Emp> queryAllEmps() {
		String sql = "select eid, ename, age, createtime from web_springcore.emp";
		RowMapper<Emp> rowMapper = (ResultSet rs, int rowNum) -> {
			Emp emp = new Emp();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setAge(rs.getInt("age"));
			emp.setCreatetime(rs.getTimestamp("createtime"));
			return emp;
		};
		List<Emp> emps = jdbcTemplate.query(sql, rowMapper);
		return emps;
	}
	
	// 多筆查詢 III
		public List<Emp> queryAllEmps2() {
			String sql = "select eid, ename, age, createtime from web_springcore.emp";
			List<Emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Emp.class));;
			return emps;
		}
	
	// 單筆新增 I
	public int addOne1String (String ename, Integer age) {
		String sql = "insert into web_springcore.emp(ename, age) values(?, ?)";
		int rowcount = jdbcTemplate.update(sql, ename, age);
		return rowcount; 
	}
	
	// 單筆新增 II
	public int addOne2 (String ename, Integer age) {
		String sql = "insert into web_springcore.emp(ename, age) values(:ename, :age)";
		MapSqlParameterSource params = new MapSqlParameterSource()
										.addValue("ename", ename)
										.addValue("age", age);
		int rowcount = namedParameterJdbcTemplate.update(sql, params);
		return rowcount; 
	}
	
	// 批次多筆新增 I
	public int[ ] batchAdd1 (List<Object[ ]> rows) { 
		String sql = "insert into web_springcore.emp(ename, age) values(?, ?)";
		return jdbcTemplate.batchUpdate(sql, rows);
	}
	
	
	// 批次多筆新增 II
	public int[] batchAdd2(List<Emp> emps) {
		String sql = "insert into web_springcore.emp(ename, age) values(?, ?)";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// i = emps 的 index
				ps.setString(1, emps.get(i).getEname());
				ps.setInt(2, emps.get(i).getAge());
			}

			@Override
			public int getBatchSize() {
				return emps.size();
			}
		};
		return jdbcTemplate.batchUpdate(sql, setter);
	}
	
	
	// 修改
	public int updateById(Integer eid, String ename, Integer age) {
		String sql = "update web_springcore.emp set ename=?, age=? where eid=?";
		return jdbcTemplate.update(sql, ename, age, eid);
	}
	
	// 刪除
	public int deleteById(Integer eid) {
		String sql = "delete from web_springcore.emp where eid=? ";
		return jdbcTemplate.update(sql, eid);
	}
	
	// 取得單筆資料
	public Emp getEmpById(Integer id) {
		String sql = "select eid, ename, age, createtime from web_springcore.emp where eid=? ";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class), id );
	}
	
	// Emp一對多Job 查詢
		public List<Emp> queryEmpAndJob() {
			String sql = "select e.eid, e.ename, e.age, e.createtime, " +
					     "j.jid as job_jid, j.jname as job_jname, j.eid as job_eid " +
					     "from emp e left join job j on j.eid = e.eid";
			// j.jid as job_jid 這樣的命名 "job_jid" 表示將 jid 的內容對應 job
			
			ResultSetExtractor<List<Emp>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
					.addKeys("eid")
					.newResultSetExtractor(Emp.class);
			
			return jdbcTemplate.query(sql, resultSetExtractor);
		}
		
		// Job多對一Emp 查詢
		public List<Job> queryJobAndEmp() {
			String sql = "select j.jid, j.jname, j.eid, " +
						 "e.eid as emp_eid, e.ename as emp_ename, e.age as emp_age, e.createtime as emp_createtime " +
						 "from job j left join emp e on e.eid = j.eid";
			
			ResultSetExtractor<List<Job>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
					.addKeys("jid")
					.newResultSetExtractor(Job.class);
			
			return jdbcTemplate.query(sql, resultSetExtractor);
		}
	
	
	
}
