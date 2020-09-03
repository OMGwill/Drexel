#!/usr/bin/awk -f

BEGIN { print "#Count of letter grades"}
BEGIN { print "Grade	Count" }

{grade=$2+$3+$4+$5+$6+$7+$8+$9+$10+$11+$12} 


{if (grade<=100.0 && grade>=97.0) 
	countAplus++;	
else if (grade<97.0 && grade >=93.0)
	countA++;
else if	(grade<93.0 && grade >=90.0)
	countAminus++;
else if (grade<90.0 && grade>=87.0) 
        countBplus++;    
else if (grade<87.0 && grade >=83.0)
        countB++;
else if (grade<83.0 && grade >=80.0)
        countBminus++;
else if (grade<80.0 && grade>=77.0)
        countCplus++;
else if (grade<77.0 && grade >=73.0)
        countC++;
else if (grade<73.0 && grade >=70.0)
        countCminus++;
else if (grade<70.0 && grade>=67.0)
        countDplus++;
else if (grade<67.0 && grade >=60.0)
        countD++;
else if (grade<60.0)
        countF++;
}


END { print "A+	" countAplus }
END { print "A	" countA }
END { print "A-	" countAminus }
END { print "B+	" countBplus }
END { print "B	" countB }
END { print "B-	" countBminus }
END { print "C+	" countCplus }
END { print "C	" countC }
END { print "C-	" countCminus }
END { print "D+	" countDplus }
END { print "D	" countD }
END { print "F	" countF }


	

