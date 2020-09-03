set 	term dumb

set title "Animal Immigration by Year"
set style data histogram
set style fill solid border -1
set style histogram cluster gap 1
set key fixed right top vertical Right noreverse noenhanced autotitle nobox
set xtics border in scale 0,0 nomirror rotate by -45  autojustify
set xrange [ * : * ] noreverse writeback
set x2range [ * : * ] noreverse writeback
set yrange [ 0.00000 : 33 ] noreverse writeback
set y2range [ * : * ] noreverse writeback
set zrange [ * : * ] noreverse writeback
set cbrange [ * : * ] noreverse writeback
set rrange [ * : * ] noreverse writeback
set xtics  norangelimit 
set xtics   ()

plot	"bar.dat" using 2:xtic(1) ti col, \
	"bar.dat" using 3 ti col, \
	"bar.dat" using 4 ti col, \
	"bar.dat" using 5 ti col

set term png
set output "bar.png"
replot
set term x11

