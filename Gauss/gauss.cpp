#include <iostream>
#include <vector>
#include <cmath>
#include <sstream>

using namespace std;

class EliminacaoGauss 
{
	public:
		EliminacaoGauss(istream& in)
		{
			cout << "Digite o numero de linhas:" << endl;
			in >> height;
			cout << "Digite o numero de colunas:" << endl;
			in >> width;
			cout << "Digite a matriz de coeficientes:" << endl;
			A.resize(height);
			B.resize(height);
			X.resize(height);
			for(int i = 0; i < height; i++)
			{
				A[i].resize(width - 1);
				cout << "Digite os valores da linha " << i+1 << endl;
				for(int j = 0; j < width - 1; j++)
				{
					cout << "Digite A[" << i+1 << "," << j+1 << "]: " << endl;
					in >> A[i][j];
				}
				cout << "Digite B[" << i+1 << "]: " << endl;
				in >> B[i];
				cout << endl;
			}
		}
		void mostrarLinha(int index)
		{
			cout << "L[" << index+1 << "]: [ ";
			for(int i = 0; i < width - 1; i++)
				cout << A[index][i] << " ";
			cout << "| " << B[index] << " ]\n";
		}
		void mostrarMatriz()
		{
			for(int i = 0; i < height; i++)
				mostrarLinha(i);
		}
		void melhorPivo(int Pivot)
		{
			int iimax = Pivot;
			for(int k = Pivot+1; k < height; k++)
				if(A[iimax][Pivot] < A[k][Pivot])
					iimax = k;
			if(iimax != Pivot)
			{
				cout << endl << "Trocando linha " << Pivot+1 << " pela linha " << iimax+1 << endl;
				swap(A[iimax], A[Pivot]);
				swap(B[iimax], B[Pivot]);
				mostrarMatriz();
			}
		}
		void escalonar()
		{
			cout << endl << "Aplicando eliminassao de Gauss" << endl;
			mostrarMatriz();
			for(int k = 0; k < height - 1; k++)
			{
				melhorPivo(k);
				for(int j = k+1; j < height; j++)
				{
					double m = A[j][k] / A[k][k];
					cout << endl << "Escalar linha " << j+1 << " usando M=" << m << endl;
					for(int i=k; i < width - 1; i++)
					{
						cout << "L[" << j+1 << "," << i+1 << "] = " << A[j][i] << " - " << m * A[k][i]  << " => ";
						A[j][i] = A[j][i] - m * A[k][i];
						cout << A[j][i] << endl;
					}
					cout << "B[" << j+1 << "] = " << B[j] << " - " << m * B[k]  << " => ";
					B[j] = B[j] - m * B[k];
					cout << B[j] << endl << "Matriz atual:" << endl;
					mostrarMatriz();
				}
			}
			cout << endl << "Variaveis:" << endl;
			for(int k = height-1; k >= 0; k--)
			{
				X[k] = B[k];
				for(int j = width-2; j > k; j--)
				{
					X[k] -= A[k][j] * X[j];
				}
				X[k] /= A[k][k];
			}
			for(int k = 0; k < height; k++)
				cout << "X[" << k+1 << "]: "  << X[k] << endl;
			cout << endl << "Fim!";
		}
	private:
		vector< vector<double> > A;
		vector<double> B, X;
		int width;
		int height;
};


int main()
{
	EliminacaoGauss t {cin};
	t.escalonar();
	return 0;
};
