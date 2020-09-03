all: letters.txt line.png bar.png letters.dat letters.png

letters.txt: grades.awk student.dat 
	awk -f grades.awk student.dat > letters.txt

line.png: line_example.plot line.dat
	gnuplot line_example.plot

bar.png: bar_example.plot bar.dat
	gnuplot bar_example.plot

letters.dat: prepare_student.awk student.dat
	awk -f prepare_student.awk student.dat > letters.dat

letters.png: letters.dat letters.plot
	gnuplot letters.plot

clean:
	-rm *.png
	-rm letters.txt
	-rm letters.dat
