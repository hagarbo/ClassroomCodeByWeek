<div class="row">
    <?php
    if (count($dataToView["data"]) > 0) {
        foreach ($dataToView["data"] as $user) {
    ?>
            <div class="col-md-3 card border border-secondary rounded m-2">
                <img src="<?= ".." . DIRECTORY_SEPARATOR . FILES_FOLDER . DIRECTORY_SEPARATOR . "default_avatar.jpeg" ?>" class="card-img-top" alt="No picture">
                <div class="card-body ">
                    <h5 class="card-title"><?php echo $user->getEmail(); ?></h5>
                    <div class="card-text"><?php echo $user->getEmail(); ?></div>
                </div>
            </div>
        <?php
        }
    } else {
        ?>
        <div class="alert alert-info">
            Actualmente no existen Usuarios.
        </div>
    <?php
    }
    ?>
</div>