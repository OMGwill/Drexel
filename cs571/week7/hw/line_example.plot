set 	term dumb

set title "Line Comparison"

plot	"line.dat" using 1:2 title 'f(x)' with lines, \
	"line.dat" using 1:3 title 'g(x)' with lines

set term png
set output "line.png"
replot
set term x11
