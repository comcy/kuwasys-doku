#! /bin/bash

##
# LaTeX Makefile-Skript - Projektarbeit KuWaSys Schillerschule Aalen
#

pdflatex PA-01-Projekt_PDFVersion_KuWaSys.tex

makeglossaries PA-01-Projekt_PDFVersion_KuWaSys.glo

bibtex PA-01-Projekt_PDFVersion_KuWaSys.aux

pdflatex PA-01-Projekt_PDFVersion_KuWaSys.tex

pdflatex PA-01-Projekt_PDFVersion_KuWaSys.tex
