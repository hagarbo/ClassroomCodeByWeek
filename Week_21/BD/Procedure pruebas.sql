delimiter !!
drop procedure if exists numeroRomano!!
create procedure numeroRomano (numero int)
begin
declare cadena varchar(255);
set cadena="";

M:  while numero >= 1000 do
set cadena= concat (cadena,'M');
set numero=numero-1000;
end while M;

if (numero>=900) then
set cadena= concat (cadena,'CM');
set numero=numero-900;
end if;

D:  while numero >= 500 do
set cadena= concat (cadena,'D');
set numero=numero-500;
end while D;

if (numero>=400) then
set cadena= concat (cadena,'CD');
set numero=numero-400;
end if;

C:  while numero >= 100 do
set cadena= concat (cadena,'C');
set numero=numero-100;
end while C;

if (numero>=90) then
set cadena= concat (cadena,'XC');
set numero=numero-90;
end if;

L:  while numero >= 50 do
set cadena= concat (cadena,'L');
set numero=numero-50;
end while L;

if (numero>=40) then
set cadena= concat (cadena,'Xl');
set numero=numero-40;
end if;

X:  while numero >= 10 do
set cadena= concat (cadena,'X');
set numero=numero-10;
end while X;

if (numero>=9) then
set cadena= concat (cadena,'IX');
set numero=numero-9;
end if;

if (numero>=5) then
set cadena= concat (cadena,'V');
set numero=numero-5;
end if;

if (numero>=4) then
set cadena= concat (cadena,'IV');
set numero=numero-4;
end if;

I:  while numero >= 1 do
set cadena= concat (cadena,'I');
set numero=numero-1;
end while I;

select cadena;
end!!
delimiter ;


call numeroRomano(2024);

; delimiter !!
drop procedure if exists bucleRomano3 !!
create procedure bucleRomano3 (INOUT cadena TEXT, INOUT numero int, valor int, simbolo varchar(2))
begin
while (numero>=valor) do
set cadena= concat (cadena, simbolo);
set numero=numero-valor;
end while;
end;
!! delimiter ;



