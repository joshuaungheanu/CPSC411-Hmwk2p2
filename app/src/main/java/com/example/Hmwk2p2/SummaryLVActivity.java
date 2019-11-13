// Joshua Ungheanu 897883294

package com.example.Hmwk2p2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.Hmwk2p2.model.Student;
import com.example.Hmwk2p2.model.StudentDB;
import com.example.Hmwk2p2.model.CourseEnrollment;
import com.example.Hmwk2p2.adapter.SummaryLVAdapter;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class SummaryLVActivity extends Activity {

    protected ListView mSummaryView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.summary_listview);

        createStudentObjects();
        mSummaryView = findViewById(R.id.summary_list_view_id);
        SummaryLVAdapter ad = new SummaryLVAdapter();
        mSummaryView.setAdapter(ad);
    }

    protected void createStudentObjects() {
        Student s1 = new Student("Josh", "Ungheanu", 88888888);
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC411", "A"));
        courses.add(new CourseEnrollment("CPSC440", "C"));
        s1.setCourses(courses);

        Student s2 = new Student("Bob", "Dylan", 11111111);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC240", "A"));
        s2.setCourses(courses);

        Student s3 = new Student("Donald", "Trump", 22222222);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC444", "F"));
        s3.setCourses(courses);

        ArrayList<Student> studentList = new ArrayList<> ();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        StudentDB.getInstance().setStudents(studentList);
    }
    public void goToActivity (View view){
        Intent intent = new Intent(SummaryLVActivity.this, addStudent.class);
        startActivity(intent);
    }
}
