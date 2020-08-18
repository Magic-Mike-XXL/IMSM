package com.ilemelamncp.IMSDMS;

public class ReportModel
{
	
	private String teacherName, schoolName, weeklyReport, classAttendance, totalAbsent, absenteeNames;
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setWeeklyReport(String weeklyReport) {
		this.weeklyReport = weeklyReport;
	}

	public String getWeeklyReport() {
		return weeklyReport;
	}

	public void setClassAttendance(String classAttendance) {
		this.classAttendance = classAttendance;
	}

	public String getClassAttendance() {
		return classAttendance;
	}

	public void setTotalAbsent(String totalAbsent) {
		this.totalAbsent = totalAbsent;
	}

	public String getTotalAbsent() {
		return totalAbsent;
	}

	public void setAbsenteeNames(String absenteeNames) {
		this.absenteeNames = absenteeNames;
	}

	public String getAbsenteeNames() {
		return absenteeNames;
	}
	
	public String getInsertionValues(ReportModel model) {
		return "('"+ teacherName + "', '" + schoolName + "', '" + weeklyReport + "', '" + classAttendance + "', '" + totalAbsent + "', '" + absenteeNames + "')";
	}

	public String getTableValues() {
		return "(TeacherName, SchoolName, WeeklyReport, ClassAttendance, TotalAbsent, AbsenteeNames)";
	}
}
