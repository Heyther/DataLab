package rmfarc.tacoma.uw.edu.webservicelab.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Robert and Heather on 4/20/2016.
 */
public class Course implements Serializable{

    String mCourseId, mShortDescription, mLongDescription, mPrereqs;

    public static final String ID = "id", SHORT_DESC = "shortDesc"
            , LONG_DESC = "longDesc", PRE_REQS = "prereqs";


    public Course(String courseId, String shortDesc, String longDesc, String prereqs){
        mCourseId = courseId;
        mShortDescription = shortDesc;
        mLongDescription = longDesc;
        mPrereqs = prereqs;
    }

    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "This part of the string seems unneeded, Reason: " + e.getMessage();
            }
        }
        return reason;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public void setmCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setmShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public String getLongDescription() {
        return mLongDescription;
    }

    public void setmLongDescription(String mLongDescription) {
        this.mLongDescription = mLongDescription;
    }

    public String getPrereqs() {
        return mPrereqs;
    }

    public void setmPrereqs(String mPrereqs) {
        this.mPrereqs = mPrereqs;
    }
}
