#include <iostream>
#include <stdio.h>
#include <string.h>
#include <conio.h>

using namespace std;

struct estudiante
{
    char nombre[10]; // 1*10 = 10 bytes
    int ci; // 4 bytes
    float nota; // 4 byts
    int estado; // 4 byts
};

class archivo
{
    public:
        FILE *arch;
    public:
        // archivo(); no tiene funcion constructora
        void crear(char[]); // parametro el nombre del archivo  que recibe
        void adresgistro(char[]); // para adicionar datos al resgitro
        void reporte(char[], int); // para mostra
        /* si int = 1. reporte general
                    2. reporte activos
                    3. reporte inactivos
        */
        int buscar(char[], int); // buscar 
        void modireg(char[], int);  // para modificar
        void elilogica(char[], int);
        void restaurar(char[], int);
        void elifisica(char[]); // para borrar permanentemente
        void menu(char[]); // recibe como parametro el nombre de los  archivos
};

// implementacion de los metodos (funciones)
// creacion de archivo
void archivo::crear(char nomarch[]){
    arch = fopen(nomarch,"wb"); // para modo de escritura 'w' y en formato binario 'b'
    if(arch == NULL)
        {
        cout << "\n ERROR EN LA APERTURA DEL ARCHIVO";
        }
        else
        {
            fclose(arch); // cerrar el archivo
            cout << "\n EL ARCHIVO SE HA CREADO CON EXITO";
        }
}

void archivo::adresgistro(char nomarch[]){
    // crear un tipo de dato estudiante
    estudiante reg;
    arch = fopen(nomarch, "ab+");// a de apen, b binario, + de modo ampliado
    if (arch == NULL) {
        cout << "\n ERROR EN LA APERTURA DEL ARCHIVO";
    } else {
        cout << "CI: ";         cin >> reg.ci;
        cout << "NOMBRE: ";     cin >> reg.nombre;
        cout << "NOTA: ";       cin >> reg.nota;
        reg.estado = 1; // se creara activo
        // grabar el resgistro
        // fwrite(donde_esta_inf.?, tamanio, cuantas_veces, en_que_archivo?
        fwrite(&reg,sizeof(estudiante), 1, arch);
        fclose(arch); // cerrar el achirvo
        cout << "\n EL RESGITRO SE HA GRABADO CON EXITO";
    }
}

void archivo::reporte(char nomarch[], int tipo){
        /* si int = 1. reporte general
                    2. reporte activos
                    3. reporte inactivos
        */
    estudiante reg;
    arch = fopen(nomarch,"rb"); // rb para leer 'lectura'
    if(arch == NULL){
        cout << "\n ERROR EN LA APERTURA DEL ARCHIVO ";
    } else {
        cout << "\n\tCONTENIDO GENERAL DE REGITRO DE ARCHIVO";
        cout << "\n=======================================================";
        printf("\n %-10s %-10s %-10s %-10s","CI","NOMBRE","NOTA","ESTADO");
        cout << "\n=======================================================";
        
        fread(&reg,sizeof(estudiante),1,arch); // leer el archivo
        while (!feof(arch)) // mientras no llega al final
        {
            if (tipo == 1) { // Reporte general
                printf("\n %-10d %-10s %-10.2f %-10d", reg.ci, reg.nombre, reg.nota, reg.estado);
            } else if (tipo == 2 && reg.estado == 1) { // Solo activos
                printf("\n %-10d %-10s %-10.2f %-10d", reg.ci, reg.nombre, reg.nota, reg.estado);
            } else if (tipo == 3 && reg.estado == 0) { // Solo inactivos
                printf("\n %-10d %-10s %-10.2f %-10d", reg.ci, reg.nombre, reg.nota, reg.estado);
            } else if (tipo < 1 || tipo > 3) {
                cout << "\n TIPO DE REPORTE NO VALIDO" << endl;
                break; // Salir del ciclo si el tipo de reporte no es válido
            }
            // al final leer de nuevo
            fread(&reg,sizeof(estudiante),1,arch); // leer el archivo 
           
        }
        cout << "\n=======================================================";
        fclose(arch);
        cout << "\n FIN DEL CONTENIDO DEL ARCHIVO";
    }
}

int archivo::buscar(char nomarch[], int clave){
    estudiante reg;
    int pos, sw = 0; // sw 0 si no esta, 1 si esta
    arch = fopen(nomarch,"rb");
    if(arch == NULL){
        cout << "\n  ERROR EN LA APERTURA DEL ARCHIVO";
        return -1;
    }else{
        while (!feof(arch) && sw == 0)
        {
            fread(&reg, sizeof(estudiante), 1, arch);
            if(clave == reg.ci){
                sw = 1;
            }
        }
    }
    if(sw == 0){
        pos = -1;
    }else{
        pos = ftell(arch) - sizeof(estudiante); // ftell(arch) nos da la posicion original del archivo
    }
    fclose(arch);
    return pos;
}

void archivo::modireg(char nomarch[], int ci) {
    int pos = buscar(nomarch, ci);  // almacenar la posición
    estudiante reg;
    if (pos == -1) { // si no existe
        cout << "\n NO SE ENCUENTRA EL ARCHIVO";
    } else { // si existe
        arch = fopen(nomarch, "rb+"); // para lectura y escritura
        if (arch == NULL) {
            cout << "\n ERROR EN LA APERTURA DEL ARCHIVO";
        } 
            else {
                // ubicarse en el lugar del registro
                fseek(arch, pos, SEEK_SET); // en que archivo?, en que posicion?, del principio

                // leer el registro del archivo
                fread(&reg, sizeof(estudiante), 1, arch);

                        if (reg.estado == 0) {  // no está activo
                            cout << "\n EL ARCHIVO NO ESTA ACTIVO";
                        }
                        else {  // está activo
                            // Mostrar el registro a modificar
                            cout << "\n\tCONTENIDO  DE REGISTRO A MODIFICAR";
                            cout << "\n=======================================================";
                            printf("\n %-10s %-10s %-10s %-10s", "CI", "NOMBRE", "NOTA", "ESTADO");
                            cout << "\n=======================================================";
                            printf("\n %-10d %-10s %-10.2f %-10d", reg.ci, reg.nombre, reg.nota, reg.estado);
                            cout << "\n=======================================================";

                            cout << "\n INGRESAR LA NUEVA INFORMACION AL REGISTRO\n";
                            cout << "CI: ";         cin >> reg.ci;
                            cout << "NOMBRE: ";     cin >> reg.nombre;
                            cout << "NOTA: ";       cin >> reg.nota;

                            // ubicarse en el mismo lugar del registro
                            fseek(arch, pos, SEEK_SET);
                            fwrite(&reg, sizeof(estudiante), 1, arch);
                            cout << "\n PROCESO REALIZADO";
                        }
                fclose(arch);
            }
    }
}

void archivo::elilogica(char nomarch[], int ci) {
    int pos = buscar(nomarch, ci);  // almacenar la posición
    estudiante reg;
    if (pos == -1) { // si no existe
        cout << "\n NO SE ENCUENTRA EL ARCHIVO";
    } else { // si existe
        arch = fopen(nomarch, "rb+"); // para lectura y escritura
        if (arch == NULL) {
            cout << "\n ERROR EN LA APERTURA DEL ARCHIVO";
        } 
            else {
                // ubicarse en el lugar del registro
                fseek(arch, pos, SEEK_SET);
                // leer el registro del archivo
                fread(&reg, sizeof(estudiante), 1, arch);

                        if (reg.estado == 0) {  // no está activo
                            cout << "\n EL ARCHIVO YA ESTA ELIMINADO";
                        }
                        else {  // está activo
                            // Mostrar el registro a modificar
                            cout << "\n\tCONTENIDO  DE REGISTRO A MODIFICAR";
                            cout << "\n=======================================================";
                            printf("\n %-10s %-10s %-10s %-10s", "CI", "NOMBRE", "NOTA", "ESTADO");
                            cout << "\n=======================================================";
                            printf("\n %-10d %-10s %-10.2f %-10d", reg.ci, reg.nombre, reg.nota, reg.estado);
                            cout << "\n=======================================================";

                            reg.estado = 0;

                            // ubicarse en el mismo lugar del registro
                            fseek(arch, pos, SEEK_SET);
                            fwrite(&reg, sizeof(estudiante), 1, arch);
                            cout << "\n RESGISTRO ELIMINADO";
                        }
                fclose(arch);
            }
    }
}

void archivo::restaurar(char nomarch[], int ci) {
    int pos = buscar(nomarch, ci);  // almacenar la posición
    estudiante reg;
    if (pos == -1) { // si no existe
        cout << "\n NO SE ENCUENTRA LA CLAVE";
    } else { // si existe
        arch = fopen(nomarch, "rb+");
        if (arch == NULL) {
            cout << "\n ERROR EN LA APERTURA DEL ARCHIVO";
        } 
            else {
                // ubicarse en el lugar del registro
                fseek(arch, pos, SEEK_SET);
                // leer el registro del archivo
                fread(&reg, sizeof(estudiante), 1, arch);

                        if (reg.estado == 1) {  // no está activo
                            cout << "\n EL REGISTRO YA ESTA ACTIVO";
                        }
                        else {  // está activo
                            // Mostrar el registro a modificar
                            cout << "\n\tCONTENIDO  DE REGISTRO A RESTAURAR";
                            cout << "\n=======================================================";
                            printf("\n %-10s %-10s %-10s %-10s", "CI", "NOMBRE", "NOTA", "ESTADO");
                            cout << "\n=======================================================";
                            printf("\n %-10d %-10s %-10.2f %-10d", reg.ci, reg.nombre, reg.nota, reg.estado);
                            cout << "\n=======================================================";

                            reg.estado = 1;

                            // ubicarse en el mismo lugar del registro
                            fseek(arch, pos, SEEK_SET);
                            fwrite(&reg, sizeof(estudiante), 1, arch);
                            cout << "\n RESGISTRO RESTAURADO";
                            getch();
                        }
                fclose(arch);
            }
    }
}

void archivo::elifisica(char nomarch[]){
    estudiante reg;
    FILE *archtmp; // archivo temporal, puntero a archivo
    arch = fopen(nomarch, "rb"); // abrir para lectura
    archtmp = fopen("datos.tmp","wb+"); // para lectura y escritura

    // verificar que ambos archivos se abran
    if(arch == NULL || archtmp == NULL){
        cout <<"\n ERROR EN LA APERTURA DEL ARCHIVO";
    }
    // sino, copiar todos los registros del archivo origal al temporal con el campo estado 1
    else{
        // lectura
        fread(&reg, sizeof(estudiante), 1, arch);
        while (!feof(arch))
        {
            if(reg.estado == 1){ // si estado es 1, guardar
                fwrite(&reg, sizeof(estudiante), 1, archtmp);
            }
            fread(&reg, sizeof(estudiante), 1, arch);
        }
        // cerra los dos archivos
        fclose(arch);
        fclose(archtmp);
       
        remove(nomarch);    // borrar el archivo orignal

        //renombrar(archivo_temporal, archivo original)
        rename("datos.tmp", nomarch);  // renombrar el archivo original por el temporal
        cout << "\n  EL ARCHIVO SE BORRO PERMANENTEMENTE\n";
    }

}

void archivo::menu(char nomarch[]){
    int op = 0, ci;
    do{
        
        system("cls"); // limpiar la pantalla
        cout << "\n=====================================================";
        cout << "\n\t PROCESAMIENTO DE ARCHIVOS";
        cout << "\n=====================================================";
        cout << "\n1.- CREAR EL ARCHIVO VACIO";
        cout << "\n2.- ADICION DE UN REGISTRO";
        cout << "\n3.- REPORTE GENERAL DEL ARCHIVO COMPLETO";
        cout << "\n4.- REPORTE DE REGISTROS ACTIVOS";
        cout << "\n5.- REPORTE DE REGISTROS INACTIVOS";
        cout << "\n6.- MODIFICAR LA INFORMACION DEL ARCHIVO";
        cout << "\n7.- ELIMINACION LOGICA DE REGISTRO";
        cout << "\n8.- RESTAURACION DE REGISTRO";
        cout << "\n9.- ELIMINACION FISICA DEL REGISTROS INACTIVOS";
        cout << "\n10.- SALIR";
        cout << "\n=====================================================";
        cout << "\n ELIJA UNA OP.: ";
        cin >> op;
        switch (op)
        {
        case 1: system("cls");
                crear(nomarch);
                getch();
                break;
        case 2: system("cls");
                adresgistro(nomarch);
                getch();
                break;
        case 3: system("cls");
                cout << "\n REPORTE GENERAL";
                reporte(nomarch, 1);
                getch();
                break;
        case 4: system("cls");
                cout << "\n REPORTE ACTVO";
                reporte(nomarch, 2);
                getch();
                break;
        case 5: system("cls");
                cout << "\n REPORTE INACTIVO";
                reporte(nomarch, 3);
                getch();
                break;
        case 6: system("cls");
                cout << "\n CI DE REG. A MODIGICAR: "; cin >> ci;
                modireg(nomarch, ci);
                getch();
                break;
        case 7: system("cls");
                cout << "\n CI DE REG. A ELIMINAR: "; cin >> ci;
                elilogica(nomarch, ci);
                getch();
                break;
        case 8: system("cls");
                cout << "\n CI DE REG. A RESTAURAR: "; cin >> ci;
                restaurar(nomarch, ci);
                getch();
                break;
        case 9: system("cls");
                cout << "\n ELIMINACION FISICA ";
                elifisica(nomarch);
                getch();
                break;
        case 10: system("cls");
                cout << "\n Saliendo... se va :v";
                getch();
                break;
        }
    }while (op != 10);
}
int main(){
    char noma[15];

    strcpy(noma,"curso.dat");
    archivo a;
    a.menu(noma);
    return 0;
}