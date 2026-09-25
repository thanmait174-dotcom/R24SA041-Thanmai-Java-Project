package com.reva.exam.service;
import com.reva.exam.model.Attempt;
public interface ResultProcessor { double calculatePercentage(Attempt attempt); String getGrade(Attempt attempt); }
