
delimiter //

create trigger nivel_riesgo
after insert on puntospeligro for each row
begin
declare suma int; -- suma
declare c int; -- num puntos
declare nivel int;

select sum(nivel_gravedad) into suma from puntospeligro 
where ruta_id_rutas=new.rutas_id_ruta; -- suma valores

select count(*) into c from puntospeligro 
where rutas_id_ruta=new.rutas_id_ruta; -- cuenta todos los puntos con el mismo id

set nivel=round(suma/c);
update rutas set nivel_riesgo=nivel where id_ruta=new.rutas_id_ruta;

end//


