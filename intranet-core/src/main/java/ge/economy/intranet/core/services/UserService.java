package ge.economy.intranet.core.services;

import ge.economy.intranet.core.api.dto.UserDTO;
import ge.economy.intranet.core.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserDAO userDAO;

    public UserDTO getUser(String username, String password)
    {
        return UserDTO.translate(this.userDAO.getUser(username, password));
    }
}
