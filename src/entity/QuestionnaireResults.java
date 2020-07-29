package entity;

import java.util.Arrays;
import java.util.Date;

/**
 * 调查问卷的结果
 */
public class QuestionnaireResults {
    //序号
    private String id;
    //提交日期
    private String date;
    //问卷题目
    private String title;
    //问卷选项
    private String[] choice;

    public QuestionnaireResults(String id,String date,String title,String[] choice){
        this.id=id;
        this.date=date;
        this.title=title;
        this.choice=choice;
    }

    public QuestionnaireResults(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getChoice() {
        return choice;
    }

    public void setChoice(String[] choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "QuestionnaireResults{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", choice=" + Arrays.toString(choice) +
                '}';
    }

    /**
     * 将数组转为字符串存储，用逗号分割
     * @return String
     */
    public String int2string(){
        StringBuilder sb=new StringBuilder();
        for (String value : choice) {
            sb.append(value.trim()).append(",");
        }
        return sb.toString();
    }

    public String[] string2int(String choice){
        return choice.split(",");
    }
}
