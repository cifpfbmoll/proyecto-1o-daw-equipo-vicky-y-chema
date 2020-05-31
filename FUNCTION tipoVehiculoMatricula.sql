CREATE OR REPLACE FUNCTION tipoVehiculoMatricula(codMatricula text)
RETURNS int AS $$
BEGIN
    IF EXISTS (SELECT * FROM especificaciones_coches WHERE matricula = $1) THEN
        RETURN 0;
    ELSIF EXISTS (SELECT * FROM especificaciones_caravanas WHERE matricula = $1) THEN
        RETURN 1;
    ELSE
        RETURN 2;
    END IF;
END;
$$language plpgsql;