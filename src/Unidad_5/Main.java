package Unidad_5;

public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto();
        producto.setDescripcion("Laptop HP");
        producto.setIdproducto(101);
        producto.setStockminimo(5);
        producto.setStockactual(10);

        Pedido pedido = new Pedido();
        pedido.setIdproducto(producto.getIdproducto());

        // Hacer que Pedido escuche los eventos de Producto
        producto.addPropertyChangeListener(pedido);

        // 🔽 Disminuir stock hasta llegar a 0
        System.out.println("\n🔽 Bajando el stock...");
        producto.setStockactual(3);
        producto.setStockactual(0); // Debería activar stock crítico y poner el pedido en espera

        // 📦 Reposición de stock
        System.out.println("\n📦 Reponiendo stock...");
        producto.setStockactual(10); // Debería reactivar el pedido

        // ❌ Descontinuar producto
        System.out.println("\n❌ Descontinuando producto...");
        producto.setDisponible(false); // El pedido debería cancelarse
    }
}
