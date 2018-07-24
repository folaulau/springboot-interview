package com.kaveinga.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kaveinga.interview.professor.Professor;
import com.kaveinga.interview.professor.ProfessorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewApplicationTests {

	@Autowired
	private ProfessorService professorService;
	
	@Test
	public void load() {
		BufferedReader fileReader = null;
		String fileName = "professors.csv";

		try {

			fileReader = new BufferedReader(new FileReader(fileName));
			String heads = fileReader.readLine();
			System.out.println(heads);
			String line = "";

			while ((line = fileReader.readLine()) != null) {
				System.out.println("Line: " + line);
				String[] items = line.split(",");
				Long id = Long.parseLong(items[0]);
				String rank = items[1];
				String discipline = items[2];
				Integer yrsWithPhd = Integer.parseInt(items[3]);
				Integer yrsService = Integer.parseInt(items[4]);
				String sex = items[5];
				Double salary = Double.parseDouble(items[6]);
				String name = items[7];
				Professor professor = new Professor();
				professor.setId(id);
				professor.setDiscipline(discipline);
				professor.setName(name);
				professor.setRank(rank);
				professor.setSalary(salary);
				professor.setSex(sex);
				professor.setYrsService(yrsService);
				professor.setYrsWithPhd(yrsWithPhd);
				professor = professorService.create(professor);
				System.out.println(professor.toJson());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
