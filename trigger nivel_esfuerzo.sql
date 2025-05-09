
delimiter //

create trigger nivel_esfuerzo before insert on rutas for each row
begin
DECLARE puntos INT default 0; 

  SET puntos = puntos + CASE
    WHEN NEW.duracion < 30 THEN 2
    WHEN NEW.duracion < 60 THEN 4
    WHEN NEW.duracion < 120 THEN 6
    ELSE 8
  END;
  
 SET puntos = puntos + CASE
    WHEN NEW.distancia < 5 THEN 2
    WHEN NEW.distancia < 10 THEN 3
    WHEN NEW.distancia < 15 THEN 4
    WHEN NEW.distancia < 20 THEN 5
    WHEN NEW.distancia < 25 THEN 6
    WHEN NEW.distancia < 30 THEN 7
    ELSE 8
  END;

SET puntos = puntos + CASE
    WHEN NEW.desnivel_acumulado < 100 THEN 2
    WHEN NEW.desnivel_acumulado < 300 THEN 3
    WHEN NEW.desnivel_acumulado < 500 THEN 4
    WHEN NEW.desnivel_acumulado < 600 THEN 5
    WHEN NEW.desnivel_acumulado < 800 THEN 6
    WHEN NEW.desnivel_acumulado < 1000 THEN 7
    ELSE 8
  END;

set puntos=round(puntos/3);
set NEW.nivel_esfuerzo=puntos;
end//




