package tools.h2_dbunit.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


@SuppressWarnings("serial")
public class MyTest {

    private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
	private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	@BeforeClass
	public static void createSchema() throws Exception {
		RunScript.execute(JDBC_URL, USER, PASSWORD, "/Users/zhangmengxi/learning/datastruct-algorithm/tools/h2_dbunit/test/schema.sql", StandardCharsets.UTF_8, false);
	}

	@Before
	public void importDataSet() throws Exception {
		IDataSet dataSet = readDataSet();
		cleanlyInsert(dataSet);
	}

	private IDataSet readDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new File("/Users/zhangmengxi/learning/datastruct-algorithm/tools/h2_dbunit/test/data.xml"));
	}

	private void cleanlyInsert(IDataSet dataSet) throws Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
    }
    
    private DataSource getDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL(JDBC_URL);
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}

	@Test
	public void selectAllTest() throws Exception {
        Connection conn = getDataSource().getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from PERSON");

        List<String[]> dummyBuf = new ArrayList<String[]>() {{
            while (resultSet.next()) {
                this.add(new String[] {
                    resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)
                });
            }
        }};
        
        List<String[]> expected = new ArrayList<String[]>() {{
            this.add(new String[] {"1", "Bob", "18"});
            this.add(new String[] {"2", "Alice", "23"});
            this.add(new String[] {"3", "Charlie", "42"});
        }};

        assertEquals(expected.size(), dummyBuf.size());
        for (int i=0; i<expected.size(); i++) {
            String[] expectedItem = expected.get(i), dummyBufItem = dummyBuf.get(i);
            
            assertEquals(expectedItem.length, dummyBufItem.length);
            for (int j=0; j<expectedItem.length; j++) {
                assertEquals(expectedItem[j], dummyBufItem[j]);
            }
        }
	}

}
