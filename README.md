# trabajo práctico Integrador de POO 1
# Diego Fernández Hunko y Nicolás Kosak.

Proyecto 2:
Una empresa que se dedica a la producción y venta de artículos de acero y aluminio
como ser tubos y piezas para automóviles, desea centralizar los pedidos de producción
mediante un planificador de pedidos. Dicho planificador permitirá a los clientes, indicar
los artículos que necesitan, la forma de envasado de los mismos y las distintas fechas en
las que deben ser entregados.
La empresa dispone de un conjunto de envases que se encuentran codificados, los cuales
son para un tipo de artículo y tienen cierta capacidad definida. De cada artículo se
conoce su código, descripción, largo, ancho y diámetro.
A partir de los pedidos realizados por los clientes, la empresa podrá, a partir de su stock,
determinar las cantidades a producir, y los plazos que tiene para enviar los productos a
sus clientes.
De cada cliente se conoce su código de cliente, nro. de CUIT, razón social y domicilio
fiscal. Al realizar un pedido el cliente debe especificar la fecha de primer entrega, la
cantidad de entregas que se deberán realizar y la periodicidad de las mismas (Única Vez,
Semanal o Mensual). Con dicha información el sistema determina las fechas de entrega
que tendrá el pedido. Luego, el usuario ingresará los artículos a pedir indicando, para
cada artículo, el código que lo identifica y las cantidades a pedir para cada una de las
fechas de entrega.
El sistema deberá permitir al usuario seleccionar el envase en el que se entregará cada
tipo de artículo para cada fecha de entrega. Para ello el usuario tiene que previamente
consultar los envases disponibles para un tipo de artículo determinado. Una vez
ingresados todos los artículos, el sistema retorna el identificador del nuevo pedido
