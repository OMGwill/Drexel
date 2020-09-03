#!/usr/bin/awk -f

BEGIN { print "Final Exam Letter Grades"}

BEGIN { FS=OFS="\t" }

{grade=$2+$3+$4+$5+$6+$7+$8+$9+$10+$11+$12} 

{sum+=grade}

{if (grade<=100.0 && grade>=97.0) 
	letter="A+";	
else if (grade<97.0 && grade >=93.0)
	letter="A";
else if	(grade<93.0 && grade >=90.0)
	letter="A-";
else if (grade<90.0 && grade>=87.0) 
        letter="B+";    
else if (grade<87.0 && grade >=83.0)
        letter="B";
else if (grade<83.0 && grade >=80.0)
        letter="B-";
else if (grade<80.0 && grade>=77.0)
        letter="C+";
else if (grade<77.0 && grade >=73.0)
        letter="C";
else if (grade<73.0 && grade >=70.0)
        letter="C-";
else if (grade<70.0 && grade>=67.0)
        letter="D+";
else if (grade<67.0 && grade >=60.0)
        letter="D";
else if (grade<60.0)
        letter="F";
}


{ printf "%s	%0.2f	%s\n" ,$1,grade,letter }

END { print "Analyzed " NR " student grades." }
	
END { printf "%s %.02f\n","Class Average: ",sum/NR }
