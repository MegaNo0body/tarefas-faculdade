/*
Compilar usando g++ nome_do_arquivo.cpp

Variaveis:
F = 8 - (4.5 * (x - sin(x)))
a = 2
b = 3
imax = 20
tol = 0.001

Resultado:
k=1 a=2 b=3 m=2.5 Fm= -0.55688 tolerancia= 0.5
k=2 a=2 b=2.5 m=2.25 Fm= 1.3763 tolerancia= 0.25
k=3 a=2.25 b=2.5 m=2.375 Fm= 0.43408 tolerancia= 0.125
k=4 a=2.375 b=2.5 m=2.4375 Fm= -0.055709 tolerancia= 0.0625
k=5 a=2.375 b=2.4375 m=2.4062 Fm= 0.19066 tolerancia= 0.03125
k=6 a=2.4062 b=2.4375 m=2.4219 Fm= 0.067838 tolerancia= 0.015625
k=7 a=2.4219 b=2.4375 m=2.4297 Fm= 0.0061545 tolerancia= 0.0078125
k=8 a=2.4297 b=2.4375 m=2.4336 Fm= -0.024755 tolerancia= 0.0039062
k=9 a=2.4297 b=2.4336 m=2.4316 Fm= -0.0092946 tolerancia= 0.0019531
k=10 a=2.4297 b=2.4316 m=2.4307 Fm= -0.0015686 tolerancia= 0.00097656
Solucao aproximada com F(2.4307) = -0.0015686 menor que a tolerancia
*/
#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

double f(double x)
{
	return 8 - (4.5 * (x - sin(x)));
}

int main()
{
	double a = 2, b = 3, imax = 20, tol = 0.001, Fa = f(a), Fb = f(b);
	if(Fa * Fb > 0)
	{
		cout << "Fa(x); Fb(x) precisam ter sinais distintos." << endl;
	} else {
		for(int i = 0; i < imax; i++)
		{
			double m = (a + b) / 2;
			double itol = abs((b - a) / 2);
			double Fm = f(m);
			cout.precision(5);
			cout << "k=" <<  i+1 <<  " a=" << a << " b=" << b << " m=" << m << " Fm= " << Fm <<  " tolerancia= " << itol << endl;
			if(Fm == 0)
			{
				cout << "Solucao exata com F(" << m << ") = 0" << endl;
				break;
			} else {
				if(itol < tol)
				{
					cout << "Solucao aproximada com F(" << m << ") = " << Fm << " menor que a tolerancia" << endl;
					break;
				}
				if(f(a) * Fm < 0) // se o intervalo [a, m] possuir a raiz (F(X) == 0), entao b=m e [a, m] == [a, b]
				{
					b = m;
				} else { // caso contrario, o intervalo [a, b] possui a raiz
					a = m;
				}
			}
		}
	}
}
