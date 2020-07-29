package daoimpl;

import dao.QuestionnaireDao;
import entity.QuestionnaireResults;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireDaoImpl implements QuestionnaireDao {
    @Override
    public void add(QuestionnaireResults questionnaireResults) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;

        conn= DBUtils.getConnection();

        try {
            String sql="insert into questionnaire(date, title, choice, id) VALUES (?,?,?,?)";
            ps=conn.prepareStatement(sql);

            ps.setString(1,questionnaireResults.getDate());
            ps.setString(2,questionnaireResults.getTitle());
            ps.setString(3,questionnaireResults.int2string());
            ps.setString(4,questionnaireResults.getId());

            int res=ps.executeUpdate();
            if (res>0){
                System.out.println("successfully");
            }else {
                System.out.println("failed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
    }

    @Override
    public void delete(String id) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;

        conn= DBUtils.getConnection();

        try {
            String sql="delete from questionnaire where id=?";
            ps=conn.prepareStatement(sql);

            ps.setString(1,id);

            int res=ps.executeUpdate();
            if (res>0){
                System.out.println("successfully");
            }else {
                System.out.println("failed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
    }

    @Override
    public List<QuestionnaireResults> findBy(String id) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        QuestionnaireResults questionnaireResults=null;
        ResultSet rs=null;
        List<QuestionnaireResults> list=new ArrayList<>();

        conn= DBUtils.getConnection();

        try {
            String sql="select date, title, choice, id from questionnaire where id=?";
            ps=conn.prepareStatement(sql);

            ps.setString(1,id);

            rs=ps.executeQuery();
            while (rs.next()){
                questionnaireResults=new QuestionnaireResults();
                questionnaireResults.setDate(rs.getString(1));
                questionnaireResults.setTitle(rs.getString(2));
                questionnaireResults.setChoice(questionnaireResults.string2int(rs.getString(3)));
                questionnaireResults.setId(rs.getString(4));

                list.add(questionnaireResults);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(rs,ps,conn);
        }
        return list;
    }

    @Override
    public List<QuestionnaireResults> findAll() throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        QuestionnaireResults questionnaireResults=null;
        ResultSet rs=null;
        List<QuestionnaireResults> list=new ArrayList<>();

        conn= DBUtils.getConnection();

        try {
            String sql="select date, title, choice, id from questionnaire";
            ps=conn.prepareStatement(sql);


            rs=ps.executeQuery();
            while (rs.next()){
                questionnaireResults=new QuestionnaireResults();
                questionnaireResults.setDate(rs.getString(1));
                questionnaireResults.setTitle(rs.getString(2));
                questionnaireResults.setChoice(questionnaireResults.string2int(rs.getString(3)));
                questionnaireResults.setId(rs.getString(4));

                list.add(questionnaireResults);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(rs,ps,conn);
        }
        return list;
    }
}
