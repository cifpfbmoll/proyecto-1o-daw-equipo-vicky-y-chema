alter table detalles_reserva
drop constraint detalles_reserva_numreserva_fkey;

alter table detalles_reserva
add constraint detalles_reserva_numreserva_fkey foreign key (numreserva) references reservas (numreserva)
on delete cascade
on update cascade;